package com.blog.Blog_App_Api1.Services;

import com.blog.Blog_App_Api1.entities.User;
import com.blog.Blog_App_Api1.repositories.UserRepo;

public interface UserService  extends UserRepo{

	User createUser(User user);
}
