package com.kallavaninc.vaultnexus.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "platform_accounts",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "platform_name", "external_account_id"})
)
@Getter
@Setter
@NoArgsConstructor
public class PlatformAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "platform_name", nullable = false, length = 100)
    private String platformName;

    @Column(name = "external_account_id", nullable = false, length = 200)
    private String externalAccountId;

    @Column(name = "display_name", length = 200)
    private String displayName;

    @Column(name = "linked_at", nullable = false, updatable = false)
    @Setter(AccessLevel.NONE)
    private LocalDateTime linkedAt;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(name = "api_access_token", length = 500)
    private String apiAccessToken;

    @Column(name = "api_refresh_token", length = 500)
    private String apiRefreshToken;

    @Column(name = "token_expires_at")
    private LocalDateTime tokenExpiresAt;

    @OneToMany(mappedBy = "platformAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> games = new ArrayList<>();

    @PrePersist
    protected void onLink() {
        this.linkedAt = LocalDateTime.now();
    }

    // Optional helper for relationship
    public void addGame(Game game) {
        games.add(game);
        game.setPlatformAccount(this);
    }
}

