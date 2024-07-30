package com.practise.userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practise.userservice.bean.User;
import com.practise.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService ferService;

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/login/{userName}/{password}")
	public ResponseEntity<Integer> login(@PathVariable String userName, @PathVariable String password) {
		logger.info("Login:: userName: " + userName + ", password: " + password);
		// 2. Call the service for business logic execution

		int userId = ferService.login(userName, password);

		// 3. Display the status
		if (userId > 0) {
			return new ResponseEntity<Integer>(userId, HttpStatus.OK);
		} else {
			return new ResponseEntity<Integer>(HttpStatus.PRECONDITION_FAILED);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestBody User user) {
		logger.info("Login:: request: " + user);

		// 2. Call the service for business logic execution
		boolean isRegister = ferService.registration(user);

		// 3. Display the status
		if (isRegister) {
			return new ResponseEntity<String>("User registeration is successful...!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("User registeration is failed...!", HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/getUser")
	public ResponseEntity<User> getUser(@RequestParam int userId) {
		User user = ferService.getUser(userId);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody User user) {

		boolean isUpdated = ferService.updateUser(user);
		if (isUpdated) {
			return new ResponseEntity<String>("User update is successful...!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("User update is failed...!", HttpStatus.NOT_MODIFIED);
		}
	}

	@PutMapping("/reset/{newPassword}/{id}/{currentPassword}")
	public ResponseEntity<String> reset(@RequestParam String newPassword, @RequestParam int id,
			@RequestParam String currentPassword) {
		// 2. Call the service for business logic execution
		boolean isReset = ferService.resetPassword(newPassword, id, currentPassword);

		// 3. Display the status
		if (isReset) {
			return new ResponseEntity<String>("Password updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Password update is failed", HttpStatus.PRECONDITION_FAILED);
		}
	}

}
