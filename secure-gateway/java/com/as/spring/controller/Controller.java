package com.as.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.spring.entity.User;
import com.as.spring.repository.UserRepository;

@RestController
public class Controller {

	@Autowired
	private UserRepository repo;

	/*
	 * @GetMapping public String get() { User user = repo.findByUsername("jaya");
	 * System.out.println(user); return "This is the Spring Security app" + user; }
	 */
	
	@RequestMapping("/")
	public String home() {
		return "Home.jsp";
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		return "Login.jsp";
	}
	
	@RequestMapping("/logout-success")
	public String logoutPage() {
		return "Logout.jsp";
	}
	
}
