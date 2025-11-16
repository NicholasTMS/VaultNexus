package com.kallavaninc.vaultnexus.repository;

import com.kallavaninc.vaultnexus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
