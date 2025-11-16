package com.kallavaninc.vaultnexus.controller;

import com.kallavaninc.vaultnexus.DTO.AchievementDTO.AchievementRequestDTO;
import com.kallavaninc.vaultnexus.DTO.AchievementDTO.AchievementResponseDTO;
import com.kallavaninc.vaultnexus.service.AchievementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/achievements")
public class AchievementController {

    private final AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @PostMapping
    public ResponseEntity<AchievementResponseDTO> createAchievement(
            @RequestBody AchievementRequestDTO dto) {
        AchievementResponseDTO created = achievementService.createAchievement(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<List<AchievementResponseDTO>> getAchievementsByGame(
            @PathVariable Long gameId) {
        List<AchievementResponseDTO> achievements = achievementService.getByGameId(gameId);
        return ResponseEntity.ok(achievements);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AchievementResponseDTO> updateAchievement(
            @PathVariable Long id,
            @RequestBody AchievementRequestDTO dto) {
        AchievementResponseDTO updated = achievementService.updateAchievement(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAchievement(@PathVariable Long id) {
        achievementService.deleteAchievement(id);
        return ResponseEntity.noContent().build();
    }
}
