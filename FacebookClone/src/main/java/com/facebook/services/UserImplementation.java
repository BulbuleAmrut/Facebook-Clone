package com.facebook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook.entities.User;
import com.facebook.repositories.UserRepository;
@Service
public class UserImplementation implements UserService {

	@Autowired
	UserRepository repo;

	@Override
	public String addUser(User usr) {
		repo.save(usr);
		return "User added";
	}

	@Override
	public boolean userExists(String username, String email) {
		User usr1=repo.findByUsername(username);
		User usr2=repo.findByEmail(email);
		if(usr1!=null || usr2!=null)
		{  //If user Already exists
			return true;
		}
		
		return false;
	}

	@Override
	public boolean validate(String username, String password) {
		
		String db_password= repo.findByUsername(username).getPassword();
		if(db_password.equals(password))
			return true;
		return false;
	}

	@Override
	public boolean usernameExists(String username) {
		User usr=repo.findByUsername(username);
		if(usr!=null)
			return true;
		return false;
	}

}
