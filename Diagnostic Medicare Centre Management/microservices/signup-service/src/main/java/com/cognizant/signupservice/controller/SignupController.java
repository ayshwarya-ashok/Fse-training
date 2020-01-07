package com.cognizant.signupservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.signupservice.exception.UserAlreadyExistsException;
import com.cognizant.signupservice.model.Admin;
import com.cognizant.signupservice.model.Customer;
import com.cognizant.signupservice.model.Doctor;
import com.cognizant.signupservice.model.Medicare;
import com.cognizant.signupservice.service.SignupService;

@RestController
@RequestMapping("/users")
public class SignupController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SignupController.class);
	
	@Autowired
	SignupService signupService;
	
	@PostMapping("/customer-signup")
	public void signup(@RequestBody @Valid Customer customer) throws UserAlreadyExistsException {
		LOGGER.info("Start");
		signupService.customerSignup(customer);
		LOGGER.info("End");
	}
	@PostMapping("/doctor-signup")
	public void signup(@RequestBody @Valid Doctor doctor) throws UserAlreadyExistsException {
		LOGGER.info("Start");
		signupService.doctorSignup(doctor);
		LOGGER.info("End");
	}
	@PostMapping("/admin-signup")
	public void signup(@RequestBody @Valid Admin admin) throws UserAlreadyExistsException {
		LOGGER.info("Start");
		signupService.adminSignup(admin);
		LOGGER.info("End");
	}

}
