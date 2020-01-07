package com.cognizant.DiagnosticMedicare.controller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.DiagnosticMedicare.DiagnosticMedicareApplication;
import com.cognizant.DiagnosticMedicare.exception.UserAlreadyExistsException;
import com.cognizant.DiagnosticMedicare.model.Admin;
import com.cognizant.DiagnosticMedicare.model.Agent;
import com.cognizant.DiagnosticMedicare.model.Doctor;
import com.cognizant.DiagnosticMedicare.model.Patient;
import com.cognizant.DiagnosticMedicare.service.SignUpService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("")
public class SignUpController {



	private static final Logger LOGGER = LoggerFactory.getLogger(DiagnosticMedicareApplication.class);

	@Autowired
	private SignUpService signupService;

	@PostMapping("/admin-sign-up")
	public void adminSignup(@RequestBody  Admin admin) throws UserAlreadyExistsException {

		LOGGER.info("Start");

		signupService.adminSignup(admin);

		LOGGER.info("End");
	}

	@PostMapping("/customer-sign-up")
	public void customerSignup(@RequestBody  Patient patient) throws UserAlreadyExistsException {

		LOGGER.info("Start");

		signupService.patientSignup(patient);

		LOGGER.info("End");
	}

	@PostMapping("/doctor-sign-up")
	public void doctorSignup(@RequestBody  Doctor doctor) throws UserAlreadyExistsException {

		LOGGER.info("Start");

		System.out.println();
		signupService.doctorSignup(doctor);

		LOGGER.info("End");
	}
	
	@PostMapping("/agent-sign-up")
	public void agentSignup(@RequestBody  Agent agent) throws UserAlreadyExistsException {

		LOGGER.info("Start");

		signupService.agentSignup(agent);

		LOGGER.info("End");
	}
	
	@PutMapping("/doctor-update")
	public boolean doctorUpdate(@RequestBody Doctor doctor){
		return signupService.doctorUpdate(doctor);
	}
	
	@PutMapping("/customer-update")
	public boolean customerUpdate(@RequestBody Patient patient){
		return signupService.customerUpdate(patient);
	}

	
	public PasswordEncoder passwordEncoder() {

		LOGGER.info("Start");
		return new BCryptPasswordEncoder();

	}


}
