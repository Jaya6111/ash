package com.security.ex.repository;

import com.security.ex.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecurityRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
