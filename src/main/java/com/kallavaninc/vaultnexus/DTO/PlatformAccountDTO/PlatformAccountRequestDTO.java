package com.kallavaninc.vaultnexus.DTO.PlatformAccountDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatformAccountRequestDTO {
    private Long userId;
    private String platformName;
    private String externalAccountId;
    private String displayName;
}
