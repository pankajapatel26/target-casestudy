package com.casestudy.quizservice.service;

import java.util.Optional;

import com.casestudy.quizservice.model.User;

public interface UserService {
	
	public Optional<User> getUser(long userId);
	
	public User registerUser(User user);
	
	public Optional<User> loginUser(String username, String password);

	Optional<User> findOne(String username);

}
