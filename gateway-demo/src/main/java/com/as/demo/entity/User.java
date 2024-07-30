package com.as.demo.entity;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String firstName;

	private String middleName;

	private String lastName;

	private String email;

	private String username;

	private String password;

	private String mobile;

	private String createdDate;
	private String emailVerified;

	private String userType;
}
