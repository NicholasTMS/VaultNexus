package com.kallavaninc.vaultnexus.DTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    private String username;
    private String email;
    private String password;  // raw password, hash in service layer
}

