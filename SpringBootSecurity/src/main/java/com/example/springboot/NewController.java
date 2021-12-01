package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewController {
	
	@GetMapping("/user")
	String getUserLoginMessage() {
		return "you are logged in as a user";
	}
	@GetMapping("/admin")
	String getAdminMessage() {
		return "Logged in as an admin and welcome";
	}
	@GetMapping("/")
	String getPublicMessage() {
		return "welcome to the public access world";
	}
}
