package com.cognizant.medicaremanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.medicaremanagement.model.Request;
import com.cognizant.medicaremanagement.repository.RequestRepository;



@Service
public class RequestServiceImpl implements RequestService{

	
	@Autowired
	RequestRepository requestRepository;
	
	
	@Override
	public void acceptRequest(Request request) {
		requestRepository.save(request);
		
	}
	
	
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
	public List<Request> customerRequest(String customerName) {
		
		return requestRepository.customerRequest(customerName);
	}


}
