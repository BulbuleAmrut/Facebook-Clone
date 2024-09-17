package com.facebook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook.entities.Post;
import com.facebook.repositories.PostRepository;

@Service
public class PostServiceImplementation implements PostService {
	@Autowired
	PostRepository repo;

	@Override
	public void createPost(Post post) {
		repo.save(post);
		
	}

}
