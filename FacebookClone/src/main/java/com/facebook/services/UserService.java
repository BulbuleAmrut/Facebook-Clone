package com.facebook.services;

import com.facebook.entities.User;

public interface UserService {
	
	public String addUser(User usr);
	
	boolean userExists(String username,String password);

	public boolean validate(String username, String password);

	public boolean usernameExists(String username);

}
