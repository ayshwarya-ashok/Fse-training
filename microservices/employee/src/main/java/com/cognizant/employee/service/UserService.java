package com.cognizant.employee.service;

import java.util.List;

import com.cognizant.employee.model.User;

public interface UserService {
	
	public List<User> getAllUsers();
	public User getByUserName(String userName);

}
