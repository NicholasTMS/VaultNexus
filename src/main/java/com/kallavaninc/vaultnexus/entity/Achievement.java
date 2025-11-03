package com.kallavaninc.vaultnexus.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "achievements",
        uniqueConstraints = @UniqueConstraint(columnNames = {"game_id", "external_achievement_id"})
)
@Getter
@Setter
@NoArgsConstructor
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @Column(name = "external_achievement_id", nullable = false, length = 200)
    private String externalAchievementId;

    @Column(nullable = false, length = 300)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private boolean unlocked = false;

    @Column(name = "unlocked_at")
    private LocalDateTime unlockedAt;
}

