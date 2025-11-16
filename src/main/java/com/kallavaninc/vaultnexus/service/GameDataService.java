package com.kallavaninc.vaultnexus.service;

import com.kallavaninc.vaultnexus.DTO.GameDTO.GameRequestDTO;
import com.kallavaninc.vaultnexus.DTO.GameDTO.GameResponseDTO;
import com.kallavaninc.vaultnexus.entity.Game;
import com.kallavaninc.vaultnexus.entity.PlatformAccount;
import com.kallavaninc.vaultnexus.mapper.GameMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameDataService {

    private final GameRepository gameRepo;
    private final PlatformAccountRepository accountRepo;
    private final GameMapper gameMapper;

    public GameDataService(GameRepository gameRepo,
                           PlatformAccountRepository accountRepo,
                           GameMapper gameMapper) {
        this.gameRepo = gameRepo;
        this.accountRepo = accountRepo;
        this.gameMapper = gameMapper;
    }

    @Transactional
    public GameResponseDTO createGame(GameRequestDTO dto) {
        PlatformAccount pa = accountRepo.findById(dto.getPlatformAccountId())
                .orElseThrow(() -> new RuntimeException("PlatformAccount not found: " + dto.getPlatformAccountId()));
        Game game = gameMapper.toEntity(dto);
        game.setPlatformAccount(pa);
        Game saved = gameRepo.save(game);
        return gameMapper.toResponseDto(saved);
    }

    @Transactional(readOnly = true)
    public GameResponseDTO getGameById(Long gameId) {
        Game game = gameRepo.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Game not found: " + gameId));
        return gameMapper.toResponseDto(game);
    }

    @Transactional(readOnly = true)
    public List<GameResponseDTO> getGamesByUser(Long userId) {
        List<Game> games = gameRepo.findByPlatformAccountUserId(userId);
        return games.stream()
                .map(gameMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<GameResponseDTO> getGamesByAccount(Long accountId) {
        List<Game> games = gameRepo.findByPlatformAccountId(accountId);
        return games.stream()
                .map(gameMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public GameResponseDTO updateGame(Long gameId, GameRequestDTO dto) {
        Game existing = gameRepo.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Game not found: " + gameId));
        existing.setTitle(dto.getTitle());
        existing.setExternalGameId(dto.getExternalGameId());
        existing.setPlatformName(dto.getPlatformName());
        Game saved = gameRepo.save(existing);
        return gameMapper.toResponseDto(saved);
    }

    @Transactional
    public void deleteGame(Long gameId) {
        gameRepo.deleteById(gameId);
    }
}
