package com.kallavaninc.vaultnexus.mapper;
import com.kallavaninc.vaultnexus.DTO.UserRequestDTO;
import com.kallavaninc.vaultnexus.DTO.UserResponseDTO;
import com.kallavaninc.vaultnexus.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequestDTO dto);

    UserResponseDTO toResponseDto(User user);
}
