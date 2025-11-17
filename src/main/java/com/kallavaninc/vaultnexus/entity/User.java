package com.kallavaninc.vaultnexus.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor  // generates an empty constructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String username;
    private String email;
    private String password;

    @Setter(AccessLevel.NONE)
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlatformAccount> platformAccounts = new ArrayList<>();

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @PrePersist //method runs automatically just before the entity is first persisted (inserted) into the database.
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public void addPlatformAccount(PlatformAccount pa) {
        platformAccounts.add(pa);
        pa.setUser(this);
    }

    public void removePlatformAccount(PlatformAccount pa) {
        platformAccounts.remove(pa);
        pa.setUser(null);
    }
}



