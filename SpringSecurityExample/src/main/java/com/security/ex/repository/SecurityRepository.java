package com.security.ex.repository;

import com.security.ex.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecurityRepository extends JpaRepository<User, Integer> {

    List<User> findByUsername(String username);
}
