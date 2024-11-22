package com.springLearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springLearn.repository.UserRepo;



@SpringBootApplication
public class MvcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcProjectApplication.class, args);
//		UserRepo ur = (UserRepo) context.getBean("userRepo");
//		System.out.println(ur);
		
	}

}
