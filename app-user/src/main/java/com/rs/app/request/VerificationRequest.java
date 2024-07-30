package com.rs.app.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerificationRequest {

	private String toEmail;
	private String name;
	private int userId;
}
