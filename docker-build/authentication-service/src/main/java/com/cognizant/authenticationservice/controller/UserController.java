package com.cognizant.authenticationservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.authenticationservice.model.Users;
import com.cognizant.authenticationservice.service.AppUserDetailsService;

@RestController
@RequestMapping("/users")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	InMemoryUserDetailsManager inMemoryUserDetailsManager;
	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
	public PasswordEncoder passwordEncoder;

	@PostMapping("")
	public void signup(@RequestBody @Valid Users user) throws UserAlreadyExistsException {
		LOGGER.info("Start");
//		if (inMemoryUserDetailsManager.userExists(user.getUserName())) {
//			throw new UserAlreadyExistsException("Existing user!");
//		} else {
//			inMemoryUserDetailsManager.createUser(User.withUsername(user.getUserName())
//													  .password(passwordEncoder().encode(user.getPassword()))
//													  .roles("USER")
//													  .build());
//		}
		appUserDetailsService.signup(user);
		LOGGER.info("End");
	}

	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return new BCryptPasswordEncoder();
	}
}
