package com.kallavaninc.vaultnexus.mapper;
import com.kallavaninc.vaultnexus.DTO.GameRequestDTO;
import com.kallavaninc.vaultnexus.DTO.GameResponseDTO;
import com.kallavaninc.vaultnexus.entity.Game;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AchievementMapper.class)
public interface GameMapper {
    Game toEntity(GameRequestDTO dto);

    GameResponseDTO toResponseDto(Game game);
}
