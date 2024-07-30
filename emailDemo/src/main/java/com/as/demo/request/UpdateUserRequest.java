package com.as.demo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {

	private String name;
	private String email;
	private String city;
	private String country;

}
