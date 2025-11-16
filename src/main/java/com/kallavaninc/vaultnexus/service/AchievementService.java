package com.kallavaninc.vaultnexus.service;

import com.kallavaninc.vaultnexus.DTO.AchievementDTO.AchievementRequestDTO;
import com.kallavaninc.vaultnexus.DTO.AchievementDTO.AchievementResponseDTO;
import com.kallavaninc.vaultnexus.entity.Achievement;
import com.kallavaninc.vaultnexus.entity.Game;
import com.kallavaninc.vaultnexus.mapper.AchievementMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AchievementService {

    private final AchievementRepository achievementRepo;
    private final GameRepository gameRepo;
    private final AchievementMapper achievementMapper;

    public AchievementService(AchievementRepository achievementRepo,
                              GameRepository gameRepo,
                              AchievementMapper achievementMapper) {
        this.achievementRepo = achievementRepo;
        this.gameRepo = gameRepo;
        this.achievementMapper = achievementMapper;
    }

    @Transactional
    public AchievementResponseDTO createAchievement(AchievementRequestDTO dto) {
        Game game = gameRepo.findById(dto.getGameId())
                .orElseThrow(() -> new RuntimeException("Game not found: " + dto.getGameId()));
        Achievement ach = achievementMapper.toEntity(dto);
        ach.setGame(game);
        Achievement saved = achievementRepo.save(ach);
        return achievementMapper.toResponseDto(saved);
    }

    @Transactional(readOnly = true)
    public List<AchievementResponseDTO> getByGameId(Long gameId) {
        return achievementRepo.findByGameId(gameId).stream()
                .map(achievementMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public AchievementResponseDTO updateAchievement(Long id, AchievementRequestDTO dto) {
        Achievement existing = achievementRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Achievement not found: " + id));
        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setUnlocked(dto.isUnlocked());
        // optionally set unlockedAt
        Achievement saved = achievementRepo.save(existing);
        return achievementMapper.toResponseDto(saved);
    }

    @Transactional
    public void deleteAchievement(Long id) {
        achievementRepo.deleteById(id);
    }
}
