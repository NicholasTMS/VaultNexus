package com.kallavaninc.vaultnexus.DTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PlatformAccountResponseDTO {
    private Long id;
    private Long userId;
    private String platformName;
    private String externalAccountId;
    private String displayName;
    private LocalDateTime linkedAt;
    private Boolean active;
}
