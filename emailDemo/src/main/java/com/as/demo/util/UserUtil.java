package com.as.demo.util;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.as.demo.entity.User;
import com.as.demo.request.RegRequest;

@Component
public class UserUtil {

	@Autowired
	private DateUtil dateUtil;
	
	public User addToUser(@Valid RegRequest request) {
		User user = new User();
		
		
		/*
		 * BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); String
		 * encodedUsername = passwordEncoder.encode(request.getUsername()); String
		 * encodedPassword = passwordEncoder.encode(request.getPassword());
		 * 
		 * user.setUsername(encodedUsername); user.setPassword(encodedPassword);
		 */
		 		
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setCity(request.getCity());
		user.setCountry(request.getCountry());
		user.setCreatedDate(dateUtil.currentDate());
		user.setEmailVerified("N");
		return user;
	}
	
}
