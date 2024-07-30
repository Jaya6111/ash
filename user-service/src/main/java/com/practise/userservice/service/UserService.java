package com.practise.userservice.service;

import com.practise.userservice.bean.User;

public interface UserService {

	public boolean registration(User user);

	public int login(String userName, String password);

	public boolean resetPassword(String newPassword, int userId, String currentPassword);

	public boolean updateUser(User user);

	User getUser(int userId);

	boolean isUsernameAvailable(String userName);
}
