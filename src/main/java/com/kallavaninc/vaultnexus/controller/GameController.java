package com.kallavaninc.vaultnexus.controller;

import com.kallavaninc.vaultnexus.DTO.GameDTO.GameRequestDTO;
import com.kallavaninc.vaultnexus.DTO.GameDTO.GameResponseDTO;
import com.kallavaninc.vaultnexus.service.GameDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameDataService gameDataService;

    public GameController(GameDataService gameDataService) {
        this.gameDataService = gameDataService;
    }

    @PostMapping
    public ResponseEntity<GameResponseDTO> createGame(@RequestBody GameRequestDTO dto) {
        GameResponseDTO created = gameDataService.createGame(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<GameResponseDTO>> getGamesByUser(@PathVariable Long userId) {
        List<GameResponseDTO> games = gameDataService.getGamesByUser(userId);
        return ResponseEntity.ok(games);
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<GameResponseDTO>> getGamesByAccount(@PathVariable Long accountId) {
        List<GameResponseDTO> games = gameDataService.getGamesByAccount(accountId);
        return ResponseEntity.ok(games);
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GameResponseDTO> getGameById(@PathVariable Long gameId) {
        GameResponseDTO game = gameDataService.getGameById(gameId);
        return ResponseEntity.ok(game);
    }

    @PutMapping("/{gameId}")
    public ResponseEntity<GameResponseDTO> updateGame(
            @PathVariable Long gameId,
            @RequestBody GameRequestDTO dto) {
        GameResponseDTO updated = gameDataService.updateGame(gameId, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{gameId}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long gameId) {
        gameDataService.deleteGame(gameId);
        return ResponseEntity.noContent().build();
    }
}
