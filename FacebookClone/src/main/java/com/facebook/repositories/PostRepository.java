package com.facebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facebook.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
