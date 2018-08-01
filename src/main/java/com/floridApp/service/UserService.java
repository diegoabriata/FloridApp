package com.floridApp.service;



import com.floridApp.model.User;

public interface UserService {
	
	
	public User findUserByEmail(String email);
	public void saveUser(User user);
}