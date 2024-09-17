package com.facebook.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.facebook.entities.Post;
import com.facebook.services.PostService;

@Controller
public class PostController {
	@Autowired
	PostService service;

	@PostMapping("/createPost")
	public String createPost(@RequestParam String caption, @RequestParam("photo") MultipartFile photo) {

		Post post = new Post();
		post.setCaption(caption);

		LocalDateTime current = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = current.format(formatter);
		post.setDatetime(formattedDateTime);

		try {
			post.setPhoto(photo.getBytes());
		} catch (IOException e) {

			e.printStackTrace();
		}
		service.createPost(post);
		return "homePage";

	}
	
}
