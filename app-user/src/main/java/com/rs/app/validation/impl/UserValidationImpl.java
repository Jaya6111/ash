
package com.rs.app.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.rs.app.request.AddMyBooksRequest;
import com.rs.app.request.GetMyBooksRequest;
import com.rs.app.request.GetUserIdRequest;
import com.rs.app.request.LoginRequest;
import com.rs.app.request.RegistrationRequest;
import com.rs.app.validation.UserValidation;

@Component
public class UserValidationImpl implements UserValidation {

	private Logger logger;

	private Set<String> validate(Set<String> errorMessage, Object value, String fieldName) {
		//logger.info("UserValidationImpl:: inside validate()");
		if (StringUtils.isEmpty(value)) {
			errorMessage.add(fieldName + " should not be empty");
		} else if ((value instanceof Integer && Integer.parseInt(value.toString()) <= 0)
				|| (value instanceof Float && Float.parseFloat(value.toString()) <= 0)) {
			errorMessage.add(fieldName + " should not be Zero");
		}

		return errorMessage;
	}

	@Override
	public Set<String> validateRegistrationRequest(RegistrationRequest request) {
		logger.debug("UserValidationImpl:: validateRegistrationRequest(): " + request);
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validate(errorMessages, request.getFirstName(), "FirstName");
		errorMessages = validate(errorMessages, request.getLastName(), "LastName");
		errorMessages = validate(errorMessages, request.getEmail(), "Email");
		errorMessages = validate(errorMessages, request.getUsername(), "UserName");
		errorMessages = validate(errorMessages, request.getPassword(), "Password");
		errorMessages = validate(errorMessages, request.getMobile(), "Mobile");
		errorMessages = validate(errorMessages, request.getUserType(), "UserType");

		return errorMessages;
	}

	@Override
	public Set<String> validateLoginRequest(LoginRequest request) {
		logger.debug("UserValidationImpl:: validateLoginRequest(): " + request);
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validate(errorMessages, request.getUsername(), "UserName");
		errorMessages = validate(errorMessages, request.getPassword(), "Password");
		errorMessages = validate(errorMessages, request.getUserType(), "UserType");
		return errorMessages;
	}

	@Override
	public Set<String> validateGetUser(GetUserIdRequest request) {
		//logger.debug("UserValidationImpl:: validateGetUser(): " + request);
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validate(errorMessages, request.getId(), "userId");
		return errorMessages;
	}

	@Override
	public Set<String> validateAddMyBooksRequest(AddMyBooksRequest request) {
		logger.debug("UserValidationImpl:: validateAddMyBooksRequest(): " + request);
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validate(errorMessages, request.getUId(), "userId");
		errorMessages = validate(errorMessages, request.getPId(), "pIds");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetMyBooks(GetMyBooksRequest request) {
		logger.debug("UserValidationImpl:: validateGetMyBooks(): " + request);
		Set<String> errorMessages = new LinkedHashSet<String>();
		errorMessages = validate(errorMessages, request.getUId(), "userId");
		return errorMessages;
	}

}
