package com.as.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.demo.request.GetUserRequest;
import com.as.demo.request.RegRequest;
import com.as.demo.request.UpdateUserRequest;
import com.as.demo.response.GetUserResponse;
import com.as.demo.response.RegResponse;
import com.as.demo.response.UpdateUserResponse;
import com.as.demo.service.UserService;

@RestController
@Validated
@RequestMapping("/demo")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public RegResponse registration(@RequestBody @Valid RegRequest request) {
		RegResponse response = userService.register(request);
		return response;
	}

	@GetMapping("/sorted")
	public GetUserResponse getUserSorted(@RequestBody @Valid GetUserRequest request) {
		return userService.getSorted(request);
	}

	@GetMapping("/verify/{userId}")
	public String verifyEmail(@PathVariable int userId, Model model) {

		String path = null;
		model.addAttribute("userId", userId);
		boolean emailStatus = userService.verifyEmail(userId);
		if (emailStatus) {
			path = "Success";
		} else {
			path = "Failure";
		}
		return path;
	}
	
	@PutMapping("/update/{userId}")
	public UpdateUserResponse updateUser(@RequestBody @Valid UpdateUserRequest request, @PathVariable int userId) {
		return userService.updateUser(request,userId);
	}
}
