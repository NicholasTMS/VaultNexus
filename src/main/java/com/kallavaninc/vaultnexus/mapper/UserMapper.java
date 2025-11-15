package com.kallavaninc.vaultnexus.mapper;
import com.kallavaninc.vaultnexus.DTO.UserRequestDTO;
import com.kallavaninc.vaultnexus.DTO.UserResponseDTO;
import com.kallavaninc.vaultnexus.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
// This tells MapStruct to automap ur dto below into a Spring-managed implementation (e.g. UserMapperImpl) at compile time.
// The generated mapper will be a singleton Spring bean, so you can @Autowired it in your services.
public interface UserMapper {
    User toEntity(UserRequestDTO dto);

    UserResponseDTO toResponseDto(User user);
}
