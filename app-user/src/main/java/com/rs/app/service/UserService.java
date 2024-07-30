package com.rs.app.service;

import java.util.List;
import java.util.Optional;

import com.rs.app.bean.MyBooks;
import com.rs.app.bean.Product;
import com.rs.app.bean.User;
import com.rs.app.request.AddMyBooksRequest;
import com.rs.app.request.GetMyBooksRequest;
import com.rs.app.request.GetUserIdRequest;
import com.rs.app.request.LoginRequest;
import com.rs.app.request.RegistrationRequest;
import com.rs.app.request.VerificationRequest;

public interface UserService {

	public boolean registration(RegistrationRequest request);

	public User login(LoginRequest request);

	public User getUser(GetUserIdRequest request);

	public boolean addMyBooks(AddMyBooksRequest request);

	public List<Product> getMyBooks(GetMyBooksRequest request);

	public Optional<List<MyBooks>> myBooksList(String uId);

	public boolean verifyEmail(VerificationRequest request);
	
}
