package com.neo.springBoot.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.springBoot.domain.User;

@RestController
public class JsonController {
	@RequestMapping("/getUser")
	public User getUser() {
		User user = new User();
		user.setUsername("小明");
		user.setPassword("xxxx");
		System.out.println("hello 小明");
		System.out.println("test push");
		System.out.println("test pull");
		return user;
	}

}
