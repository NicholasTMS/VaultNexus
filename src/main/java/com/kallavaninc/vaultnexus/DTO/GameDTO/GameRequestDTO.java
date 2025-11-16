package com.kallavaninc.vaultnexus.DTO.GameDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameRequestDTO {
    private Long platformAccountId;
    private String externalGameId;
    private String title;
    private String platformName;
}
