package com.rs.app.feign;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.rs.app.request.LoginRequest;

@FeignClient("USER-SERVICE")
public interface ConnectUserService {

	@GetMapping("/user/login")
	public ResponseEntity<String> login(@ModelAttribute @Valid LoginRequest request);

	@GetMapping("/user/userId")
	public String userId();
}
