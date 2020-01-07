package com.cognizant.DiagnosticMedicare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.DiagnosticMedicare.model.Doctor;
import com.cognizant.DiagnosticMedicare.model.Patient;
import com.cognizant.DiagnosticMedicare.model.Request;
import com.cognizant.DiagnosticMedicare.repository.DoctorRepository;
import com.cognizant.DiagnosticMedicare.repository.PatientRepository;
import com.cognizant.DiagnosticMedicare.repository.RequestRepository;

@Service
public class RequestServiceImpl implements RequestService{

	
	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	
	@Override
	public boolean acceptRequest(Request request) {
		
		requestRepository.save(request);
		//requestRepository.adminRequest();
		return true;
		
	}
	
	/*
	public List<Request> doctorAcceptRequest(Request request) {
		System.out.println(request+"###############");
		requestRepository.save(request);
		//
		return requestRepository.doctorRequest();
		
	}
	*/

	@Override
	public void addRequest(Request request) {
		
		requestRepository.save(request);
		
	}

	@Override
	public List<Request> adminRequest() {
		
		return requestRepository.adminRequest();
	}

	@Override
	public List<Request> doctorRequest() {
		
		return requestRepository.doctorRequest();
	}

	@Override
	public List<Request> customerRequest(int  customerId) {
		
		return requestRepository.customerRequest(customerId);
	}
	
	@Override
	public Request getOneRequest(int requestId) {
		return requestRepository.findById(requestId).get();
	}

	@Override
	public Patient getOneCustomer(String customerName) {
		return patientRepository.findByUsername(customerName);
	}
	
	@Override
	public boolean bookAppointment(Request request) {
		requestRepository.save(request);
		return true;
	}

	@Override
	public Doctor getOneDoctor(String doctorName) {
		return doctorRepository.findByUserName(doctorName);
	}

}



