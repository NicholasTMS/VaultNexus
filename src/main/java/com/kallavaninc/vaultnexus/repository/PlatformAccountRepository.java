package com.kallavaninc.vaultnexus.repository;

import com.kallavaninc.vaultnexus.entity.PlatformAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformAccountRepository extends JpaRepository<PlatformAccount, Long> {
    List<PlatformAccount> findAllByUserId(Long userId);
}
