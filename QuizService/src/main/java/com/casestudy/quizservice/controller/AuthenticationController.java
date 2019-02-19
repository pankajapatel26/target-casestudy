package com.casestudy.quizservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.quizservice.filter.JwtTokenUtil;
import com.casestudy.quizservice.model.AuthToken;
import com.casestudy.quizservice.model.CustomUserDeatils;
import com.casestudy.quizservice.model.LoginUser;
import com.casestudy.quizservice.model.User;
import com.casestudy.quizservice.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(path = "/token")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	@PostMapping("/generate-token")
	public @ResponseBody AuthToken register(@RequestBody LoginUser loginUser) throws AuthenticationException {

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
		final Optional<User> user = userService.findOne(loginUser.getUsername());
		if(user == null) {
			
		}

		CustomUserDeatils userDetail = new CustomUserDeatils();
		userDetail.setFirstName(user.get().getFirstName());
		userDetail.setLastName(user.get().getLastName());
		userDetail.setPhoneNumber(user.get().getPhoneNumber());
		userDetail.setUsername(user.get().getUsername());
		userDetail.setPassword(user.get().getPassword());

		final String token = jwtTokenUtil.generateToken(userDetail);
		return new AuthToken(token, userDetail.getUsername(), user.get().getId());
	}

}