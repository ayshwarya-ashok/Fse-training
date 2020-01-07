package com.cognizant.medicaremanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.medicaremanagement.model.Request;



@Service
public interface RequestService {
	
	public void acceptRequest(Request request);
	
	public void addRequest(Request request);
	
	public List<Request> adminRequest();
	

	public List<Request> doctorRequest();
	
	
	public List<Request> customerRequest(String customerName);

}
