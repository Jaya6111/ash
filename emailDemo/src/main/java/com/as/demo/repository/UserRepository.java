package com.as.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.as.demo.entity.User;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("FROM User u WHERE LOWER(u.country) = LOWER(:country) ORDER BY u.name")
	List<User> findByCountrySorted(@Param("country") String country);

	User findByUsername(String username);

}
