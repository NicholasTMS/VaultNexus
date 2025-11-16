package com.kallavaninc.vaultnexus.repository;


import com.kallavaninc.vaultnexus.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByPlatformAccountUserId(Long userId);
    List<Game> findByPlatformAccountId(Long platformAccountId);
}
