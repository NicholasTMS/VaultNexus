package com.kallavaninc.vaultnexus.mapper;
import com.kallavaninc.vaultnexus.DTO.GameRequestDTO;
import com.kallavaninc.vaultnexus.DTO.GameResponseDTO;
import com.kallavaninc.vaultnexus.entity.Game;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AchievementMapper.class)
// This tells MapStruct to automap ur dto below into a Spring-managed implementation (e.g. UserMapperImpl) at compile time.
// The generated mapper will be a singleton Spring bean, so you can @Autowired it in your services.
public interface GameMapper {
    Game toEntity(GameRequestDTO dto);

    GameResponseDTO toResponseDto(Game game);
}
