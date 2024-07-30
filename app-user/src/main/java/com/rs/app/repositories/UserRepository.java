package com.rs.app.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.rs.app.bean.User;

@EnableMongoRepositories
@Repository
public interface UserRepository extends MongoRepository<User, String> {

	List<User> findByUsernameAndUserType(String userName, String userType);

	//List<User> findByUsername(String username);

	User findByUsername(String username);
}
