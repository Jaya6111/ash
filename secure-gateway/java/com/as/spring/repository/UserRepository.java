package com.as.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.as.spring.entity.User;

@Repository
public interface  UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);
}
