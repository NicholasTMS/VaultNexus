package com.kallavaninc.vaultnexus.repository;

import com.kallavaninc.vaultnexus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
