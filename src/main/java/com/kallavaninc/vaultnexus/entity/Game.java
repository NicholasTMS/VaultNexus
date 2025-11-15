package com.kallavaninc.vaultnexus.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "games",
        uniqueConstraints = @UniqueConstraint(columnNames = {"platform_account_id", "external_game_id"})
)
@Getter
@Setter
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platform_account_id", nullable = false)
    private PlatformAccount platformAccount;

    @Column(name = "external_game_id", nullable = false, length = 200)
    private String externalGameId;

    @Column(nullable = false, length = 300)
    private String title;

    @Column(name = "platform_name", nullable = false, length = 100)
    private String platformName;

    @Column(name = "cover_image_url", length = 500)
    private String coverImageUrl;

    @Column(length = 100)
    private String genre;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "last_played_at")
    private LocalDateTime lastPlayedAt;

    @Column(name = "total_play_time_minutes", nullable = false)
    private Long totalPlayTimeMinutes = 0L;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Achievement> achievements = new ArrayList<>();

}
