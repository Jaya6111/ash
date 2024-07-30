package com.practise.expenseservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("USER-SERVICE")
public interface ConnectUser {
	@GetMapping("/user/login/{userName}/{password}")
	public ResponseEntity<Integer> login(@PathVariable String userName, @PathVariable String password);
}
