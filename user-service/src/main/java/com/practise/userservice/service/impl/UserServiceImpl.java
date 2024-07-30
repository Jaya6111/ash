package com.practise.userservice.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.userservice.bean.Address;
import com.practise.userservice.bean.User;
import com.practise.userservice.repository.UserRepository;
import com.practise.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	@Override
	public boolean registration(User user) {
		return userRepository.save(user).getId() > 0;
	}

	@Override
	public int login(String userName, String password) {
		List<User> users = userRepository.findByUserNameAndPassword(userName, password);
		if (users != null && !users.isEmpty()) {
			return users.get(0).getId();
		}
		return 0;
	}

	@Override
	public boolean resetPassword(String newPassword, int userId, String currentPassword) {
		User user = getUser(userId);
		if (currentPassword.equals(user.getPassword())) {
			user.setPassword(newPassword);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		return registration(user);
	}

	@Override
	public User getUser(int userId) {
		User user = null;
		Optional<User> optionalObj = userRepository.findById(userId);
		if (optionalObj.isPresent()) {
			user = optionalObj.get();
			if (user.getAddress() == null) {
				user.setAddress(new Address());
			}
		}
		return user;
	}

	@Override
	public boolean isUsernameAvailable(String userName) {

		List<User> users = userRepository.findByUserName(userName);
		return (users == null || users.isEmpty());
	}

}
