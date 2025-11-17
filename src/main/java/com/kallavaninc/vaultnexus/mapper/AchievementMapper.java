package com.kallavaninc.vaultnexus.mapper;
import com.kallavaninc.vaultnexus.DTO.AchievementDTO.AchievementRequestDTO;
import com.kallavaninc.vaultnexus.DTO.AchievementDTO.AchievementResponseDTO;
import com.kallavaninc.vaultnexus.entity.Achievement;
import org.springframework.stereotype.Component;


@Component
public class AchievementMapper {
    public Achievement toEntity(AchievementRequestDTO dto){ return new Achievement();};
    public AchievementResponseDTO toResponseDto(Achievement achievement) {return new AchievementResponseDTO();};
}
