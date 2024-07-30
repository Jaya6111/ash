package com.as.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
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

	public User() {
	}

}
