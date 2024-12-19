package com.blog.Blog_App_Api1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blog.Blog_App_Api1.repositories.UserRepo;

@SpringBootTest
class BlogAppApi1ApplicationTests {

	@Autowired
	private  UserRepo userRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void repoTest()
	{
		 String name = this.userRepo.getClass().getName();
		 
		String packageName = this.userRepo.getClass().getPackageName();
		
	    System.out.println(name);
	    System.out.println(packageName);
	}

}
