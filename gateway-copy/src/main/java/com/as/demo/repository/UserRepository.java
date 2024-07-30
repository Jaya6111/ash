package com.as.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.as.demo.entity.User;

@Repository
@EnableMongoRepositories
public interface UserRepository extends MongoRepository<User, String> {
    User  findByUsername(String username);
}
