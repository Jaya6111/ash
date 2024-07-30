package com.as.demo.response;

import org.springframework.http.HttpStatus;

import com.as.demo.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegResponse {
	private User user;
	private String message;
	private HttpStatus status;
	
}
