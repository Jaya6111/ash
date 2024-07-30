package com.as.demo.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.as.demo.entity.User;
import com.as.demo.repository.UserRepository;
import com.as.demo.request.GetUserRequest;
import com.as.demo.request.RegRequest;
import com.as.demo.request.UpdateUserRequest;
import com.as.demo.response.GetUserResponse;
import com.as.demo.response.RegResponse;
import com.as.demo.response.UpdateUserResponse;
import com.as.demo.service.UserService;
import com.as.demo.util.EmailUtil;
import com.as.demo.util.UserUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserUtil userUtil;

	@Autowired
	private EmailUtil emailUtil;

	@Override
	public RegResponse register(@Valid RegRequest request) {
		User user = userUtil.addToUser(request);
		boolean res = userRepository.save(user) != null;
		RegResponse response = new RegResponse();

		if (res) {
			try {
				// emailUtil.sendWelcomeMail(user.getEmail(), user.getName());
				emailUtil.sendVerificationMail(user.getEmail(), user.getName(), user.getId());
			} catch (EmailException e) {
				System.out.println("Failed to send the mail" + e);
			}
			response.setStatus(HttpStatus.CREATED);
			response.setUser(user);
			response.setMessage("Registration is done successfully");
		} else {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setUser(null);
			response.setMessage("Failed to register the user...");
		}
		return response;
	}

	@Override
	public GetUserResponse getSorted(@Valid GetUserRequest request) {
		List<User> users = userRepository.findByCountrySorted(request.getCountry());
		GetUserResponse response = new GetUserResponse();

		if (!users.isEmpty() && users != null) {
			response.setStatus(HttpStatus.OK);
			response.setUsers(users);
			response.setMessage("Users got found");
		} else {
			response.setStatus(HttpStatus.NOT_FOUND);
			response.setUsers(null);
			response.setMessage("Unable to find the requested data");
		}
		return response;
	}

	@Override
	public boolean verifyEmail(int userId) {

		User user = getUser(userId);
		User updatedUser = null;
		boolean emailStatus = false;
		if (user != null) {
			String storedValue = user.getEmailVerified();
			if (storedValue.equalsIgnoreCase("N") || storedValue.equals(null)) {
				user.setEmailVerified("Y");
				updatedUser = userRepository.save(user);
			}
			if (updatedUser.getEmailVerified().equals("Y") || user.getEmailVerified().equals("Y")) {
				emailStatus = true;
			}
		}

		return emailStatus;
	}

	@Override
	public User getUser(int userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public UpdateUserResponse updateUser(@Valid UpdateUserRequest request, int userId) {

		User oldUser = getUser(userId);

		UpdateUserResponse response = new UpdateUserResponse();
		User newUser = null;

		if (oldUser != null) {
			oldUser.setName(request.getName());
			oldUser.setCity(request.getCity());
			oldUser.setCountry(request.getCountry());
			oldUser.setEmail(request.getEmail());
			if(oldUser.getEmail().equals(request.getEmail())) {
				oldUser.setEmailVerified("N");
			}

			newUser = userRepository.save(oldUser);
			response.setStatus(HttpStatus.CREATED);
			response.setMessage("User details updated successfully");
		} else {
			response.setStatus(HttpStatus.CONFLICT);
			response.setMessage("Details Upgradation is failed...");
		}
		response.setUsers(newUser);
		return response;
	}

}
