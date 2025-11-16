package com.kallavaninc.vaultnexus.repository;


import com.kallavaninc.vaultnexus.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByPlatformAccountUserId(Long userId);
    List<Game> findByPlatformAccountId(Long platformAccountId);
}
