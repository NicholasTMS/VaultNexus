package com.kallavaninc.vaultnexus.DTO.GameDTO;
import com.kallavaninc.vaultnexus.DTO.AchievementDTO.AchievementResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class GameResponseDTO {
    private Long id;
    private Long platformAccountId;
    private String externalGameId;
    private String title;
    private String platformName;
    private String coverImageUrl;
    private String genre;
    private LocalDate releaseDate;
    private LocalDateTime lastPlayedAt;
    private Long totalPlayTimeMinutes;
    private List<AchievementResponseDTO> achievements;
}
