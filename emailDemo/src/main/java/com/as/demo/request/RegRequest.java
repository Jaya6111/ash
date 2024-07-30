package com.as.demo.request;

import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegRequest {

	private String name;
	@Email
	private String email;
	private String city;
	private String country;
	private String username;
	private String password;
}
