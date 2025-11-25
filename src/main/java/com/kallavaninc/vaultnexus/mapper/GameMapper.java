package com.kallavaninc.vaultnexus.mapper;

import com.kallavaninc.vaultnexus.DTO.AchievementDTO.AchievementResponseDTO;
import com.kallavaninc.vaultnexus.DTO.GameDTO.GameRequestDTO;
import com.kallavaninc.vaultnexus.DTO.GameDTO.GameResponseDTO;
import com.kallavaninc.vaultnexus.entity.Game;
import com.kallavaninc.vaultnexus.entity.PlatformAccount;
import com.kallavaninc.vaultnexus.repository.PlatformAccountRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GameMapper {

    private final PlatformAccountRepository platformAccountRepository;

    public GameMapper(PlatformAccountRepository platformAccountRepository) {
        this.platformAccountRepository = platformAccountRepository;
    }

    public Game toEntity(GameRequestDTO dto) {
        Game game = new Game();
        game.setExternalGameId(dto.getExternalGameId());
        game.setTitle(dto.getTitle());
        game.setPlatformName(dto.getPlatformName());

        // Fetch the PlatformAccount by ID and set it
        Optional<PlatformAccount> paOpt = platformAccountRepository.findById(dto.getPlatformAccountId());
        if (paOpt.isEmpty()) {
            throw new IllegalArgumentException("PlatformAccount not found with id: " + dto.getPlatformAccountId());
        }
        game.setPlatformAccount(paOpt.get());

        return game;
    }

    public GameResponseDTO toResponseDto(Game game) {
        if (game == null) {
            return null;
        }

        GameResponseDTO dto = new GameResponseDTO();
        dto.setId(game.getId());
        dto.setPlatformAccountId(game.getPlatformAccount().getId());
        dto.setExternalGameId(game.getExternalGameId());
        dto.setTitle(game.getTitle());
        dto.setPlatformName(game.getPlatformName());
        dto.setCoverImageUrl(game.getCoverImageUrl());
        dto.setGenre(game.getGenre());
        dto.setReleaseDate(game.getReleaseDate());
        dto.setLastPlayedAt(game.getLastPlayedAt());
        dto.setTotalPlayTimeMinutes(game.getTotalPlayTimeMinutes());

        // Map achievements
        if (game.getAchievements() != null) {
            List<AchievementResponseDTO> achDtos = game.getAchievements().stream()
                    .map(ach -> {
                        AchievementResponseDTO achDto = new AchievementResponseDTO();
                        achDto.setId(ach.getId());
                        achDto.setGameId(game.getId());
                        achDto.setExternalAchievementId(ach.getExternalAchievementId());
                        achDto.setName(ach.getName());
                        achDto.setDescription(ach.getDescription());
                        achDto.setUnlocked(ach.isUnlocked());
                        achDto.setUnlockedAt(ach.getUnlockedAt());
                        return achDto;
                    })
                    .collect(Collectors.toList());
            dto.setAchievements(achDtos);
        }

        return dto;
    }

}

