package com.kallavaninc.vaultnexus.repository;

import com.kallavaninc.vaultnexus.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    List<Achievement> findByGameId(Long gameId);
}

