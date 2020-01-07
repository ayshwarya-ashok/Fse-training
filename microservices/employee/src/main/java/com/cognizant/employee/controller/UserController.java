package com.cognizant.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employee.model.User;
import com.cognizant.employee.security.AppUserDetailsService;
import com.cognizant.employee.service.UserService;


@RestController
@RequestMapping("/")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	AppUserDetailsService appUserDetailsService;

	@GetMapping("users")
	public List<User> getAllEmployee() {
		return userService.getAllUsers();
	}
	
	/*
	 * @GetMapping("{userName}") public User getByUserName(@PathVariable String
	 * userName){ return userService.getByUserName(userName);
	 * 
	 * }
	 */
	
	@GetMapping("users/{username}")
	public UserDetails loadUserByUsername(@PathVariable String username) throws UsernameNotFoundException {
		return appUserDetailsService.loadUserByUsername(username);
		
	}
}
