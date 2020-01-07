package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.User;

@Service
public interface UserService {
	public List<User> getAllUsers();
	public User findByUserName(String userName);
}
