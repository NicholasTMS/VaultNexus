package com.kallavaninc.vaultnexus.mapper;

import com.kallavaninc.vaultnexus.DTO.AchievementDTO.AchievementRequestDTO;
import com.kallavaninc.vaultnexus.DTO.AchievementDTO.AchievementResponseDTO;
import com.kallavaninc.vaultnexus.entity.Achievement;
import org.springframework.stereotype.Component;

@Component
public class AchievementMapper {
    private Boolean unlocked;          // wrapper, can be null

    public Boolean getUnlocked() {     // or `isUnlocked()` if you prefer, but getter for wrapper is usually getX
        return unlocked;
    }
    public void setUnlocked(Boolean unlocked) {
        this.unlocked = unlocked;
    }

    public Achievement toEntity(AchievementRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        Achievement ach = new Achievement();
        ach.setExternalAchievementId(dto.getExternalAchievementId());
        ach.setName(dto.getName());
        ach.setDescription(dto.getDescription());
        setUnlocked(dto.isUnlocked()); // Uses Boolean instead of boolean where it can accept null, true and false instead o just true and false
        if(getUnlocked() == null)
        {
            throw new IllegalArgumentException("Unlocked cannot be null");
        }
        ach.setUnlocked(dto.isUnlocked());

        return ach;
    }

    public AchievementResponseDTO toResponseDto(Achievement ach) {
        if (ach == null) {
            return null;
        }
        AchievementResponseDTO dto = new AchievementResponseDTO();
        dto.setId(ach.getId());
        dto.setGameId(ach.getGame() != null ? ach.getGame().getId() : null);
        dto.setExternalAchievementId(ach.getExternalAchievementId());
        dto.setName(ach.getName());
        dto.setDescription(ach.getDescription());
        dto.setUnlocked(ach.isUnlocked());
        dto.setUnlockedAt(ach.getUnlockedAt());
        return dto;
    }
}

