package com.as.email.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailJSON {
	private String username;
	private String email;
	private String userId;
	private String subject;
	private String body;
	private String type;
}
