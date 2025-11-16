package com.kallavaninc.vaultnexus.service;

import com.kallavaninc.vaultnexus.DTO.PlatformAccountDTO.PlatformAccountRequestDTO;
import com.kallavaninc.vaultnexus.DTO.PlatformAccountDTO.PlatformAccountResponseDTO;
import com.kallavaninc.vaultnexus.entity.PlatformAccount;
import com.kallavaninc.vaultnexus.entity.User;
import com.kallavaninc.vaultnexus.mapper.PlatformAccountMapper;
import com.kallavaninc.vaultnexus.repository.PlatformAccountRepository;
import com.kallavaninc.vaultnexus.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatformAccountService {

    private final PlatformAccountRepository accountRepo;
    private final UserRepository userRepo;
    private final PlatformAccountMapper accountMapper;

    public PlatformAccountService(PlatformAccountRepository accountRepo,
                                  UserRepository userRepo,
                                  PlatformAccountMapper accountMapper) {
        this.accountRepo = accountRepo;
        this.userRepo = userRepo;
        this.accountMapper = accountMapper;
    }

    @Transactional
    public PlatformAccountResponseDTO linkAccount(PlatformAccountRequestDTO dto) {
        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found: " + dto.getUserId()));
        PlatformAccount pa = accountMapper.toEntity(dto);
        pa.setUser(user);
        PlatformAccount saved = accountRepo.save(pa);
        return accountMapper.toResponseDto(saved);
    }

    @Transactional(readOnly = true)
    public PlatformAccountResponseDTO getAccountById(Long id) {
        PlatformAccount pa = accountRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("PlatformAccount not found: " + id));
        return accountMapper.toResponseDto(pa);
    }

    @Transactional(readOnly = true)
    public List<PlatformAccountResponseDTO> getAccountsByUser(Long userId) {
        List<PlatformAccount> list = accountRepo.findAllByUserId(userId);
        return list.stream()
                .map(accountMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void unlinkAccount(Long id) {
        accountRepo.deleteById(id);
    }
}
