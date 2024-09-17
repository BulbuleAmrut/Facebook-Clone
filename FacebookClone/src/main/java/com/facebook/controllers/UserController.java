package com.facebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.facebook.entities.User;
import com.facebook.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;
	
	
	@PostMapping("/userRegistration")
	public String addUser(@ModelAttribute User usr,Model model)
	{ 
		String username=usr.getUsername();
		String email=usr.getEmail();
		boolean status=service.userExists(username, email);
		if(!status)
		{   
			service.addUser(usr);
			model.addAttribute("message","Successfully registered.");
			return "homePage";
		}
		model.addAttribute("message","User already Exists!!");
		return "login/signup";
	}
	@PostMapping("/login")
	public String login(@RequestParam String username,@RequestParam String password,Model model)
	{   boolean existsUsername=service.usernameExists(username);
		  if(!existsUsername)
		  {
			  model.addAttribute("message","Provide correct Email");
			  return "index";
		  }
		boolean status=service.validate(username,password);
		if(status)	
		{   model.addAttribute("message","Login Successfully");
			return "homePage";
		}
		model.addAttribute("message","Login failed!!");
		return "index";
		
	}
}
