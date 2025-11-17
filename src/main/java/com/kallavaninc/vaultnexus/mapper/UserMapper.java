package com.kallavaninc.vaultnexus.mapper;
import com.kallavaninc.vaultnexus.DTO.PlatformAccountDTO.PlatformAccountResponseDTO;
import com.kallavaninc.vaultnexus.DTO.UserDTO.UserRequestDTO;
import com.kallavaninc.vaultnexus.DTO.UserDTO.UserResponseDTO;
import com.kallavaninc.vaultnexus.entity.User;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class UserMapper {
    public User toEntity(UserRequestDTO dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setUsername(dto.getUsername());
        user.setPlatformAccounts(new ArrayList<>());
        user.setLastLoginAt(null);

        return user;
    };
    public UserResponseDTO toResponseDto(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setEmail(user.getEmail());

        // Map each PlatformAccount entity to its DTO
        List<PlatformAccountResponseDTO> paDtos = user.getPlatformAccounts().stream()
                .map(pa -> {
                    PlatformAccountResponseDTO dto = new PlatformAccountResponseDTO();
                    dto.setId(pa.getId());
                    dto.setUserId(user.getId());
                    dto.setPlatformName(pa.getPlatformName());
                    dto.setExternalAccountId(pa.getExternalAccountId());
                    dto.setDisplayName(pa.getDisplayName());
                    dto.setLinkedAt(pa.getLinkedAt());
                    dto.setActive(pa.getActive());
                    return dto;
                })
                .collect(Collectors.toList());

        userResponseDTO.setPlatformAccounts(paDtos);
        userResponseDTO.setCreatedAt(user.getCreatedAt());
        userResponseDTO.setLastLoginAt(user.getLastLoginAt());

        return userResponseDTO;
    }

}
