package com.kallavaninc.vaultnexus.mapper;
import com.kallavaninc.vaultnexus.DTO.AchievementRequestDTO;
import com.kallavaninc.vaultnexus.DTO.AchievementResponseDTO;
import com.kallavaninc.vaultnexus.entity.Achievement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AchievementMapper {
    Achievement toEntity(AchievementRequestDTO dto);
    AchievementResponseDTO toResponseDto(Achievement achievement);
}
