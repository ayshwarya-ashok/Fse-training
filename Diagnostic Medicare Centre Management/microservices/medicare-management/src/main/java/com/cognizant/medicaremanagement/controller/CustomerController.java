package com.cognizant.medicaremanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.medicaremanagement.model.Request;
import com.cognizant.medicaremanagement.service.RequestService;


@RestController
@RequestMapping("customer")

public class CustomerController {
	
	@Autowired
	RequestService requestService;
	
	
	@GetMapping("/customerViewRequest/{customerName}")
	public List<Request> customerRequest(@PathVariable String customerName){
		return requestService.customerRequest(customerName);	
	}

	@PostMapping("/request")
	public void addRequest(@RequestBody Request request){
		requestService.addRequest(request);
	}

}
