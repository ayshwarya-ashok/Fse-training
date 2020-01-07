package com.cognizant.DiagnosticMedicare.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.DiagnosticMedicare.model.Doctor;
import com.cognizant.DiagnosticMedicare.model.Patient;
import com.cognizant.DiagnosticMedicare.model.Request;

@Service
public interface RequestService {
	
public boolean acceptRequest(Request request);
	
	//public List<Request> doctorAcceptRequest(Request request)
	
	public void addRequest(Request request);
	
	public List<Request> adminRequest();
	

	public List<Request> doctorRequest();
	
	
	public List<Request> customerRequest(int customerId);
	
	public Request getOneRequest(int requestId);
	
	public Patient getOneCustomer(@PathVariable String customerName);

	public Doctor getOneDoctor(@PathVariable String doctorName);

	public boolean bookAppointment(Request request);
}
