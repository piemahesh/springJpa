package com.springLearn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springLearn.entity.User;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@PostMapping("/create/customer")
	public ResponseEntity<User> getCustemer(@RequestBody User user) {
		System.out.println(user.toString());
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody String password) {
		if (password.equals("sujitha")) {
			return new ResponseEntity<String>("this user is present", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("this user is not present", HttpStatus.BAD_REQUEST);
	}
	
//	{
//		message: "user is present",
//		isError: false;
//		statusCode: 201;
//	}

}
