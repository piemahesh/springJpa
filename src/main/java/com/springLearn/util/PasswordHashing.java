package com.springLearn.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashing {

	private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public static String hashPassword(String plainText) {
		return passwordEncoder.encode(plainText);
	}

	public static boolean verifyPassword(String plainText, String hashedPassword) {
		
		return passwordEncoder.matches(plainText, hashedPassword);
	}

}
