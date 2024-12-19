package com.blog.Blog_App_Api1.payloads;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	@Id
	private int id;

	private String name;

	private String email;

	private String password;

	private String about;

}
