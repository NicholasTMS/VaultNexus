package com.kallavaninc.vaultnexus.mapper;
import com.kallavaninc.vaultnexus.DTO.PlatformAccountDTO.PlatformAccountRequestDTO;
import com.kallavaninc.vaultnexus.DTO.PlatformAccountDTO.PlatformAccountResponseDTO;
import com.kallavaninc.vaultnexus.entity.PlatformAccount;
import com.kallavaninc.vaultnexus.entity.User;
import com.kallavaninc.vaultnexus.repository.UserRepository;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PlatformAccountMapper {

    private final UserRepository userRepository;

    public PlatformAccountMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public PlatformAccount toEntity(PlatformAccountRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        PlatformAccount pa = new PlatformAccount();
        pa.setPlatformName(dto.getPlatformName());
        pa.setExternalAccountId(dto.getExternalAccountId());
        pa.setDisplayName(dto.getDisplayName());

        // Link to the User
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "User not found with id " + dto.getUserId()));
        pa.setUser(user);
        pa.setActive(true); // or default logic

        return pa;
    }

    public PlatformAccountResponseDTO toResponseDto(PlatformAccount pa) {
        if (pa == null) {
            return null;
        }

        PlatformAccountResponseDTO dto = new PlatformAccountResponseDTO();
        dto.setId(pa.getId());
        dto.setUserId(pa.getUser().getId());
        dto.setPlatformName(pa.getPlatformName());
        dto.setExternalAccountId(pa.getExternalAccountId());
        dto.setDisplayName(pa.getDisplayName());
        dto.setLinkedAt(pa.getLinkedAt());
        dto.setActive(pa.getActive());
        return dto;
    }
}

