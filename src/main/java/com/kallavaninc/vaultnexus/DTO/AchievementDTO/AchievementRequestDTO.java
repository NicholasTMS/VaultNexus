package com.kallavaninc.vaultnexus.DTO.AchievementDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AchievementRequestDTO {
    private Long gameId;
    private String externalAchievementId;
    private String name;
    private String description;
    private boolean unlocked;
}