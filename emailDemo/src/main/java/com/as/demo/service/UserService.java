package com.as.demo.service;

import javax.validation.Valid;

import com.as.demo.entity.User;
import com.as.demo.request.GetUserRequest;
import com.as.demo.request.RegRequest;
import com.as.demo.request.UpdateUserRequest;
import com.as.demo.response.GetUserResponse;
import com.as.demo.response.RegResponse;
import com.as.demo.response.UpdateUserResponse;

public interface UserService {

	public RegResponse register(@Valid RegRequest request);

	public GetUserResponse getSorted(@Valid GetUserRequest request);

	public boolean verifyEmail(int userId);

	public User getUser(int userId);

	public UpdateUserResponse updateUser(@Valid UpdateUserRequest request, int userId);
}
