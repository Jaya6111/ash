package com.rs.app.controllers;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rs.app.bean.Product;
import com.rs.app.bean.User;
import com.rs.app.config.KafkaService;
import com.rs.app.repositories.UserRepository;
import com.rs.app.request.AddMyBooksRequest;
import com.rs.app.request.GetMyBooksRequest;
import com.rs.app.request.GetUserIdRequest;
import com.rs.app.request.LoginRequest;
import com.rs.app.request.RegistrationRequest;
import com.rs.app.request.VerificationRequest;
import com.rs.app.responce.GetUserResponce;
import com.rs.app.service.UserService;
import com.rs.app.service.impl.UserServiceImpl;
import com.rs.app.util.LoggerUtil;
import com.rs.app.validation.UserValidation;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

	@Autowired
	UserValidation userValidation;

	@Autowired
	private KafkaService kafkaService;

	@Autowired
	UserService userService;

	@Autowired
	private UserRepository userRepository;

	Logger logger = LoggerUtil.getLogger();

	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestBody RegistrationRequest request) {

		logger.info("Registration:: request: " + request);
		// Set<String> errorMessages = userValidation.validateRegistrationRequest(request);
		boolean isRegistered = false;
		if (request != null) {
			isRegistered = userService.registration(request);
			if (isRegistered) {
				return new ResponseEntity<String>("User registred successfully", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("Registration got failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/login")
	public ResponseEntity<String> login(@ModelAttribute LoginRequest request) {

		// Set<String> errorMessages = userValidation.validateLoginRequest(request);
		logger.debug("Login:: request: " + request);
		if (request != null) {
			User user = userService.login(request);
			return new ResponseEntity<String>(user.getId(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/verify")
	public String verifyEmail(@RequestBody VerificationRequest request, Model model) {

		String path = null;
		model.addAttribute("userId", request.getUserId());
		boolean emailStatus = userService.verifyEmail(request);
		if (emailStatus) {
			path = "Success";
		} else {
			path = "Failure";
		}
		return path;
	}

	int count = 1;

	@GetMapping("/getUser/{id}")
	@ResponseStatus
	// @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod ="getUserFallBack")
	// @Retry(name = "myCircuitBreaker", fallbackMethod = "getUserFallBack")
	@RateLimiter(name = "myCircuitBreaker", fallbackMethod = "getUserFallBack")
	public GetUserResponce getUser(@PathVariable String id) {
		GetUserResponce responce = new GetUserResponce();
		GetUserIdRequest request = new GetUserIdRequest();
		request.setId(id);
		Set<String> errorMessages = userValidation.validateGetUser(request);
		if (errorMessages.isEmpty() && errorMessages != null) {
			System.out.println("Attempts to connect with BOOK-SERVICE is: " + count);
			count++;
			User user = userService.getUser(request);
			responce.setErrorMessages(errorMessages);
			responce.setUser(user);
			responce.setHttpStatus(HttpStatus.OK);
			return responce;
		}
		responce.setErrorMessages(errorMessages);
		responce.setHttpStatus(HttpStatus.NOT_FOUND);
		return responce;
	}

	public GetUserResponce getUserFallBack(Exception e) {
		Set<String> errorMessages = new LinkedHashSet<String>();
		errorMessages.add("BOOK-SERVICE is not responding. Try after some time...");
		GetUserResponce responce = new GetUserResponce();
		responce.setHttpStatus(HttpStatus.SERVICE_UNAVAILABLE);
		responce.setErrorMessages(errorMessages);
		return responce;
	}

	@PutMapping("/addMyBooks/{uId}/{pId}")
	public ResponseEntity<String> addMyBooks(@PathVariable String uId, @PathVariable String pId,
			@RequestParam(required = false) String id) {

		AddMyBooksRequest request = new AddMyBooksRequest();
		request.setUId(uId);
		request.setPId(pId);
		if (id != null && !id.isEmpty())
			request.setId(id);
		Set<String> errorMessages = userValidation.validateAddMyBooksRequest(request);
		boolean added = false;
		if (errorMessages.isEmpty()) {
			added = userService.addMyBooks(request);
		}
		return (added) ? new ResponseEntity<String>("Added successfully", HttpStatus.OK)
				: new ResponseEntity<String>("adding failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/getMyBooks")
	public ResponseEntity<List<Product>> getMyBooks(@RequestParam String uId) {
		GetMyBooksRequest request = new GetMyBooksRequest();
		request.setUId(uId);

		Set<String> errorMessages = userValidation.validateGetMyBooks(request);
		if (errorMessages.isEmpty()) {
			List<Product> myBooks = userService.getMyBooks(request);
			return new ResponseEntity<>(myBooks, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/userId")
	public String userId() {
		User user = UserServiceImpl.session;
		return (user != null) ? user.getId() : null;
	}

	@GetMapping("/findByUsername")
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
