package com.blog.Blog_App_Api1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.Blog_App_Api1.Services.UserService;
import com.blog.Blog_App_Api1.payloads.ApiResponse;
import com.blog.Blog_App_Api1.payloads.UserDto;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService usersrvice;

	@PostMapping("/")
	public ResponseEntity<UserDto> createuser(@RequestBody UserDto userdto) {
		UserDto CreateUserDto = this.usersrvice.createUser(userdto);
		return new ResponseEntity<>(CreateUserDto, HttpStatus.CREATED);

	}

	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userdto, @PathVariable("userId") Integer uid)

	{
		UserDto updateUser = this.usersrvice.updateUser(userdto, uid);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}

//	@DeleteMapping("/{userId}")
//	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid) {
//		this.deleteUser(uid);
//		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Sucessfully", false), HttpStatus.OK);
//	}
//	@DeleteMapping("/{userId}")
//	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid) {
//		// Call the service layer method
//		this.usersrvice.deleteUser(uid);
//
//		// Return response
//		return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.NO_CONTENT // Use
//																												// NO_CONTENT
//																												// for
//																												// delete
//																												// operation
//		);
//	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid) {
		this.usersrvice.deleteUser(uid);

		// Return response with a success message
		return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser() {
		return ResponseEntity.ok(this.usersrvice.getAllUsers());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable("userId") Integer uid) {
		return ResponseEntity.ok(this.usersrvice.getUserById(uid));

	}
}
