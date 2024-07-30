package com.as.demo.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.as.demo.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserResponse {
	private List<User> users;
	private String message;
	private HttpStatus status;

}
