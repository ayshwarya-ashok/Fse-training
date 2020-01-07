package com.cognizant.signupservice.service;

import org.springframework.stereotype.Service;

import com.cognizant.signupservice.exception.UserAlreadyExistsException;
import com.cognizant.signupservice.model.Admin;
import com.cognizant.signupservice.model.Customer;
import com.cognizant.signupservice.model.Doctor;

@Service
public interface SignupService {
	public void customerSignup(Customer customer) throws UserAlreadyExistsException;
	public void doctorSignup(Doctor doctor) throws UserAlreadyExistsException;
	public void adminSignup(Admin admin) throws UserAlreadyExistsException;
}
