package com.blog.Blog_App_Api1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.Blog_App_Api1.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>

{

}
