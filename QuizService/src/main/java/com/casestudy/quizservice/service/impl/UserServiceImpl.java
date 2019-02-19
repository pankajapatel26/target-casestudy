package com.casestudy.quizservice.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.casestudy.quizservice.model.User;
import com.casestudy.quizservice.repo.UserRepository;
import com.casestudy.quizservice.service.UserService;
import com.casestudy.quizservice.utils.AesEncryptor;

@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Override
	public Optional<User> getUser(long userId) {
		try {
			Optional<User> user = userRepository.findById(userId);
			return user;
		} catch (Exception e) {
			LOGGER.info("Exception occured in getUser. Message " + e.getMessage());
		}
		return null;
	}

	@Override
	public User registerUser(User user) {
		try {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			user.setPassword(null);
			return user;
		} catch (Exception e) {
			LOGGER.info("Exception occured in registerUser. Message " + e.getMessage());
		}
		return null;
	}

	@Override
	public Optional<User> loginUser(String username, String password) {
		try {
			String encryptedPwd = AesEncryptor.encrypt(password);
			Optional<User> user = userRepository.findByUsernameAndPassword(username, encryptedPwd);
			return user;
		} catch (Exception e) {
			LOGGER.info("Exception occured in loginUser. Message " + e.getMessage());
		}
		return null;
	}

	@Override
	public Optional<User> findOne(String username) {
		try {
			return userRepository.findByUsername(username);
		} catch (Exception e) {
			LOGGER.info("Exception occured in findOne. Message " + e.getMessage());
		}
		return null;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.get().getUsername(),
				user.get().getPassword(), getAuthority());

	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
}
