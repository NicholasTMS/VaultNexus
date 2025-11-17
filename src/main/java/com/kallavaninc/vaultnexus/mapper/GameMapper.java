package com.kallavaninc.vaultnexus.mapper;
import com.kallavaninc.vaultnexus.DTO.GameDTO.GameRequestDTO;
import com.kallavaninc.vaultnexus.DTO.GameDTO.GameResponseDTO;
import com.kallavaninc.vaultnexus.entity.Game;
import org.springframework.stereotype.Component;


@Component
public class GameMapper {
    public Game toEntity(GameRequestDTO dto){ return new Game();};

    public GameResponseDTO toResponseDto(Game game){ return new GameResponseDTO();};
}
