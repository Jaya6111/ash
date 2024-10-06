package com.as.security.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.as.security.entity.User;
import com.as.security.repository.UserRepository;
import com.as.security.util.LoggerUtil;

@org.springframework.stereotype.Controller
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

	@Autowired
	private UserRepository repo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	private static final Logger log = LoggerUtil.getLogger();

	@GetMapping("/login")
	public String loginPage() {

		log.info("Login controller method");
		return "Login";
	}

	@GetMapping("/register")
	public String register(Model model) {
		log.info("Registration controller method");
		model.addAttribute("user", new User());
		return "Registration";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		log.info("Dashboard controller method");
		return "Dashboard";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute User user) {
		log.debug("Save Registration controller method ->" + user.toString(), user);
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		user.setEmailVerified("N");
		user.setCreatedDate(new Date().toString());
		repo.save(user);
		return "redirect:/login";
	}

	@GetMapping("/get")
	public ResponseEntity<?> getAllUsers() {
		List<User> users = repo.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PutMapping("/put")
	public String putMethod() {
		return "This is a response";
	}

}
