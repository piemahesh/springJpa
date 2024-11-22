package com.springLearn.controller;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
			User findedUser = userRepo.findById(user.getId()).get();
			System.out.println(findedUser + "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//			return {"message:" + "user is already present"};
		} catch (NoSuchElementException e) {
			userRepo.save(user);
			return user;
		} catch (Exception e) {
			return null;
		}
		return null;
//		
//		new UserRepo(user).createUser();
//		return user.toString();
	}

	@GetMapping(value = "/user", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> getAllUser() {
		List<User> userList = userRepo.findAll();
		return userList;

	}

}
