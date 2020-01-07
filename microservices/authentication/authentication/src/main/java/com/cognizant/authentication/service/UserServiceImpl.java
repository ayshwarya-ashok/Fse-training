package com.cognizant.authentication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.authentication.User;
import com.cognizant.authentication.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}
	@Override
	public User findByUserName(String userName) {
		
		return userRepository.findByUserName(userName);
	}

}
