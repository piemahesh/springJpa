package com.springLearn.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springLearn.entity.User;
import com.springLearn.repository.UserRepo;

@Controller
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepo userRepo;

	@PostMapping(value = "/create_user", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User createUser(@RequestBody User user) {
		System.out.println(user.toString() + "$$$$$$$$$$$$$$$$$$");
//		System.out.println(userRepo + "============");
		try {
			User userll = getUserById(user.getId());
			System.out.println(userll);
			if(userll == null) {
				System.out.println("user is created");
			}else {
				System.out.println("user is already present");
			}
//			User findedUser = userRepo.findById(user.getId()).get();
			userRepo.save(user);
//			System.out.println(findedUser + "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//			return {"message:" + "user is already present"};
			System.out.println("hi");
		} catch (NoSuchElementException e) {
//			userRepo.save(user);
			return user;
		} catch (Exception e) {
			return null;
		}
		return null;
//		
//		new UserRepo(user).createUser();
//		return user.toString();
	}

	@GetMapping(value = "/users", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Iterable<User> getAllUser() {
		Iterable<User> userList = userRepo.findAll();
		for(User userfromDb:userList) {
			System.out.println(userfromDb.toString());
			System.out.println("==============================================");
		}
		return userList;

	}

	@GetMapping(value = "/user", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User getUserById(@RequestParam Integer id) {
		try {
			User us = userRepo.findById(id).get();
			System.out.println(us);
			return userRepo.findById(id).get();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}

}
