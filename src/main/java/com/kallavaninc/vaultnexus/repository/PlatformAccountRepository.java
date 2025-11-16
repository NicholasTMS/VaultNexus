package com.kallavaninc.vaultnexus.repository;

import com.kallavaninc.vaultnexus.entity.PlatformAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatformAccountRepository extends JpaRepository<PlatformAccount, Long> {
    List<PlatformAccount> findAllByUserId(Long userId);
}
