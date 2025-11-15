package com.kallavaninc.vaultnexus.mapper;
import com.kallavaninc.vaultnexus.DTO.AchievementRequestDTO;
import com.kallavaninc.vaultnexus.DTO.AchievementResponseDTO;
import com.kallavaninc.vaultnexus.entity.Achievement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
// This tells MapStruct to automap ur dto below into a Spring-managed implementation (e.g. UserMapperImpl) at compile time.
// The generated mapper will be a singleton Spring bean, so you can @Autowired it in your services.
public interface AchievementMapper {
    Achievement toEntity(AchievementRequestDTO dto);
    AchievementResponseDTO toResponseDto(Achievement achievement);
}
