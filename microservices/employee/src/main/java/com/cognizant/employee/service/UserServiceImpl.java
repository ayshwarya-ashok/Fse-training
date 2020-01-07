package com.cognizant.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employee.dao.UserRepository;
import com.cognizant.employee.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public User getByUserName(String userName) {
		
		return userRepository.findByUserName(userName);
	}
	

}
