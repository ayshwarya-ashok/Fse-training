package com.cognizant.authentication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.authentication.User;

@Service
public interface UserService {
	public List<User> getAllUsers();
	public User findByUserName(String userName);
}
