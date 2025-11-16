package com.kallavaninc.vaultnexus.controller;

import com.kallavaninc.vaultnexus.DTO.PlatformAccountDTO.PlatformAccountRequestDTO;
import com.kallavaninc.vaultnexus.DTO.PlatformAccountDTO.PlatformAccountResponseDTO;
import com.kallavaninc.vaultnexus.service.PlatformAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platform-accounts")
public class PlatformAccountController {

    private final PlatformAccountService platformAccountService;

    public PlatformAccountController(PlatformAccountService platformAccountService) {
        this.platformAccountService = platformAccountService;
    }

    @PostMapping
    public ResponseEntity<PlatformAccountResponseDTO> linkAccount(
            @RequestBody PlatformAccountRequestDTO dto) {
        PlatformAccountResponseDTO created = platformAccountService.linkAccount(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatformAccountResponseDTO> getAccount(@PathVariable Long id) {
        PlatformAccountResponseDTO account = platformAccountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PlatformAccountResponseDTO>> getAccountsByUser(
            @PathVariable Long userId) {
        List<PlatformAccountResponseDTO> accounts = platformAccountService.getAccountsByUser(userId);
        return ResponseEntity.ok(accounts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> unlinkAccount(@PathVariable Long id) {
        platformAccountService.unlinkAccount(id);
        return ResponseEntity.noContent().build();
    }
}
