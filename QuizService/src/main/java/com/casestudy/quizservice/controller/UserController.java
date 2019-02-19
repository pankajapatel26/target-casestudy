package com.casestudy.quizservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.casestudy.quizservice.model.User;
import com.casestudy.quizservice.service.UserService;

@Controller
@RequestMapping(path = "/user")
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/{userId}")
	public @ResponseBody Optional<User> getUser(@PathVariable long userId) {
		Optional<User> user = userService.getUser(userId);
		return user;
	}

	@PostMapping("/register")
	public @ResponseBody User registerUser(@RequestBody User user) {
		User registeredUser = userService.registerUser(user);
		return registeredUser;
	}

}
