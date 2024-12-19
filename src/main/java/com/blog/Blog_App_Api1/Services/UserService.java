package com.blog.Blog_App_Api1.Services;

import java.util.List;

import com.blog.Blog_App_Api1.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto userdto);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);

}
