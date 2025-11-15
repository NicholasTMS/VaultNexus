package com.kallavaninc.vaultnexus.mapper;
import com.kallavaninc.vaultnexus.DTO.PlatformAccountRequestDTO;
import com.kallavaninc.vaultnexus.DTO.PlatformAccountResponseDTO;
import com.kallavaninc.vaultnexus.entity.PlatformAccount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlatformAccountMapper {
    PlatformAccount toEntity(PlatformAccountRequestDTO dto);
    PlatformAccountResponseDTO toResponseDto(PlatformAccount entity);
}
