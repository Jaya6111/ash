package com.practise.userservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practise.userservice.bean.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	List<User> findByUserNameAndPassword(String userName, String password);

	List<User> findByUserName(String userName);
}
