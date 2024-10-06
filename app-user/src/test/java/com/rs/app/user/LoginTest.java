package com.rs.app.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rs.app.bean.User;
import com.rs.app.controllers.UserController;
import com.rs.app.request.LoginRequest;
import com.rs.app.service.UserService;
import com.rs.app.validation.UserValidation;

@ExtendWith(MockitoExtension.class)
public class LoginTest {

	@InjectMocks
	private UserController usercontroller;

	@Mock
	private UserService userService;

	@Mock
	private UserValidation userValidation;

	@Test
	public void testLoginSuccess() {

		LoginRequest request = new LoginRequest();
		Set<String> errors = new LinkedHashSet<String>();
		User responce = new User();
		User user = null;

		when(userValidation.validateLoginRequest(Mockito.any())).thenReturn(errors);
		when(userService.login(Mockito.any())).thenReturn(responce);

		Set<String> errorMessages = userValidation.validateLoginRequest(request);
		if (errorMessages.isEmpty()) {
			user = userService.login(request);
		}

		assertEquals(responce, user);
	}

	@Test
	public void testLoginFailure() {

		LoginRequest request = new LoginRequest();
		Set<String> errors = new LinkedHashSet<String>();
		errors.add("");
		User responce = new User();
		User user = null;

		when(userValidation.validateLoginRequest(Mockito.any())).thenReturn(errors);
		when(userService.login(Mockito.any())).thenReturn(responce);

		Set<String> errorMessages = userValidation.validateLoginRequest(request);
		if (errorMessages.isEmpty()) {
			user = userService.login(request);
		}

		assertNotEquals(responce, user);
	}

}
