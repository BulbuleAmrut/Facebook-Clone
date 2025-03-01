package com.facebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facebook.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	

	User findByEmail(String email);

	User findByUsername(String username);
	
	

}
