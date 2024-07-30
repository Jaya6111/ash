package com.rs.app.feign;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rs.app.request.VerificationRequest;


@FeignClient("EMAIL-SERVICE")
public interface ConnectEmailService {

	@GetMapping("/email/welcome")
	public String welcomeEmail(@RequestParam @Valid String toEmail, @RequestParam String name);
	
	@GetMapping("/email/verify")
	public String verificationEmail(@RequestBody @Valid VerificationRequest request);
}
