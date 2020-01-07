package com.cognizant.DiagnosticMedicare.service;
import org.springframework.stereotype.Service;

import com.cognizant.DiagnosticMedicare.exception.UserAlreadyExistsException;
import com.cognizant.DiagnosticMedicare.model.Admin;
import com.cognizant.DiagnosticMedicare.model.Agent;
import com.cognizant.DiagnosticMedicare.model.Doctor;
import com.cognizant.DiagnosticMedicare.model.Patient;
import com.cognizant.DiagnosticMedicare.model.Users;

@Service
public interface SignUpService {
	
	public void adminSignup(Admin admin) throws UserAlreadyExistsException;
	public void patientSignup(Patient patient)  throws UserAlreadyExistsException;
	public void doctorSignup(Doctor doctor) throws UserAlreadyExistsException;
	public void agentSignup(Agent agent) throws UserAlreadyExistsException;
	public boolean doctorUpdate(Doctor doctor);
	public boolean customerUpdate(Patient patient);
	
}
