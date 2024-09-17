package com.facebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

	@GetMapping("/mapRegisterPage")
	public String userRegistration()
	{
		return "/login/signup";
	}
   @GetMapping("/mapLogin")
	public String userLogin()
	{
		return "/index";
	}
   @GetMapping("/mapCreatePost")
	public String createPost() {
		return "/createPost";
	}
	
}
