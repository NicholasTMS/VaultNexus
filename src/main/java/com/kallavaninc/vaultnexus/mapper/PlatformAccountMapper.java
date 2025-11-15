package com.kallavaninc.vaultnexus.mapper;
import com.kallavaninc.vaultnexus.DTO.PlatformAccountRequestDTO;
import com.kallavaninc.vaultnexus.DTO.PlatformAccountResponseDTO;
import com.kallavaninc.vaultnexus.entity.PlatformAccount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
// This tells MapStruct to automap ur dto below into a Spring-managed implementation (e.g. UserMapperImpl) at compile time.
// The generated mapper will be a singleton Spring bean, so you can @Autowired it in your services.
public interface PlatformAccountMapper {
    PlatformAccount toEntity(PlatformAccountRequestDTO dto);
    PlatformAccountResponseDTO toResponseDto(PlatformAccount entity);
}
