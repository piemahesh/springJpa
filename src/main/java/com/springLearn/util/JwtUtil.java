package com.springLearn.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	// jwt => json web token

	private final String SECRET_KEY = "adfasdfksdfsadfsadfsadfasdfsadfasdfasdfasfsafsadfsdfsdfsadfsadfsadfsadfsadfasd";

	private final Date EXIPRATION_TIME = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2); // for two hours

//	1s = 1000ms

	public String generateToken(String name) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(name);
		builder.setIssuedAt(new Date());
		builder.setExpiration(EXIPRATION_TIME);
		builder.signWith(SignatureAlgorithm.HS256, SECRET_KEY);
		return builder.compact();
	}

}
