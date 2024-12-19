package com.blog.Blog_App_Api1.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Blog_App_Api1.Services.UserService;
import com.blog.Blog_App_Api1.entities.User;
import com.blog.Blog_App_Api1.exceptions.ResourceNotFoundException;
import com.blog.Blog_App_Api1.payloads.UserDto;
import com.blog.Blog_App_Api1.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userdto) {
		User user = this.dtoToUser(userdto);
		User savedUser = this.userRepo.save(user);
		return this.UserTodto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userdto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setAbout(userdto.getAbout());

		User updateduser = this.userRepo.save(user);
		UserDto userTodto1 = this.UserTodto(updateduser);
		return userTodto1;

	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		return this.UserTodto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.UserTodto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepo.delete(user);
	}

//	@Override
//	public void deleteUser(Integer userId) {
//		User user = this.userRepo.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
//		this.userRepo.delete(user);
//	}

	private User dtoToUser(UserDto userdto) {

		User user = new User();
		user.setId(userdto.getId());
		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		user.setAbout(userdto.getAbout());
		user.setPassword(userdto.getAbout());

		return user;
	}

	public UserDto UserTodto(User user) {

		UserDto userdto = new UserDto();
		userdto.setId(user.getId());
		userdto.setName(user.getName());
		userdto.setEmail(user.getEmail());
		userdto.setAbout(user.getAbout());
		userdto.setPassword(user.getAbout());

		return userdto;
	}

}
