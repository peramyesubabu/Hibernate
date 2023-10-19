package com.example.demo.service;

import com.example.demo.entity.Users;

public interface UserService {
//adds new user to database
	String addUser(Users user);

	// checks email is already present in database or not
	boolean checkEmail(String email);

	// validates user's credentials
	boolean validate(String email, String password);

	Users getUser(String email);

	String getUserRole(String email);

	String updateUser(Users user);
}
