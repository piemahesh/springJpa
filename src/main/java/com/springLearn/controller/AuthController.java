package com.springLearn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springLearn.entity.Customer;
import com.springLearn.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private final JwtUtil jwtUtil;

	public AuthController(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Customer customer) {

		if (customer.getEmail().equals("sujitha@gmail.com") && (customer.getUsername().equals("sujitha"))) {

			String token = jwtUtil.generateToken(customer.getUsername());
			return ResponseEntity.ok(token);
		} else {
			String message = "this is not a valid user";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
		}
	}

}
