package com.rs.app.bean;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "user")
@Setter
@Getter
@ToString
public class User {
	@Id
	private String id;

	private String firstName;
	private String middleName;
	private String lastName;
	
	private String username;
	private String password;

	private String email;
	private String mobile;

	private String createdDate;
	private String emailVerified;

	
	private String userType;

	@DBRef
	private List<Product> products;

	@DBRef
	private Set<String> pIds;

	public User() {
	}

}
