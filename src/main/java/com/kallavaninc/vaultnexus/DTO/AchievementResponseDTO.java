package com.kallavaninc.vaultnexus.DTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AchievementResponseDTO {
    private Long id;
    private Long gameId;
    private String externalAchievementId;
    private String name;
    private String description;
    private boolean unlocked;
    private LocalDateTime unlockedAt;
}
