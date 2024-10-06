package com.as.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.as.security.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);
	
	/*
	 * @Query("SELECT u FROM User u WHERE u.place = :place ORDER BY u.id ASC")
	 * List<User> findByPlaceWithLimit(@Param("place") String place, Pageable
	 * pageable);
	 */
}
