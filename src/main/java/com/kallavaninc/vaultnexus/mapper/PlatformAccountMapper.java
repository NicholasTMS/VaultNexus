package com.kallavaninc.vaultnexus.mapper;
import com.kallavaninc.vaultnexus.DTO.PlatformAccountDTO.PlatformAccountRequestDTO;
import com.kallavaninc.vaultnexus.DTO.PlatformAccountDTO.PlatformAccountResponseDTO;
import com.kallavaninc.vaultnexus.entity.PlatformAccount;
import org.springframework.stereotype.Component;


@Component
public class PlatformAccountMapper {
    public PlatformAccount toEntity(PlatformAccountRequestDTO dto){ return new PlatformAccount();};
    public PlatformAccountResponseDTO toResponseDto(PlatformAccount entity){return new PlatformAccountResponseDTO();};
}
