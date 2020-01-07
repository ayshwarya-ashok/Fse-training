package com.cognizant.medicaremanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.medicaremanagement.model.Customer;
import com.cognizant.medicaremanagement.model.Doctor;
import com.cognizant.medicaremanagement.model.Medicare;
import com.cognizant.medicaremanagement.model.Request;
import com.cognizant.medicaremanagement.service.AdminService;
import com.cognizant.medicaremanagement.service.RequestService;


@RestController
@RequestMapping("admin")

public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	
	@Autowired
	RequestService requestService;
	
		
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctorList(){
		return adminService.getAllDoctorList();
		
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomerList(){
		return adminService.getAllCustomerList();
		
	}
	
	@GetMapping("/medicare-services")
	public List<Medicare> getAllMedicareList(){
		return adminService.getAllMedicareList();
		
	}
	
	@DeleteMapping("/removeCustomer-signup/{userName}")
	public List<Customer> removeCustomer(@PathVariable String userName) {	
		return adminService.removeCustomer(userName);
	}
	
	@DeleteMapping("/removeDoctor-signup/{userName}")
	public List<Doctor> removeDoctor(@PathVariable String userName) {	
		return adminService.removeDoctor(userName);
	}
	
	@PutMapping("/requestUpdate") 
	public void acceptRequest(@RequestBody Request request) {
		requestService.acceptRequest(request);
	}
	
	@GetMapping("/adminViewRequest")
	public List<Request> adminRequest(){
		return requestService.adminRequest();	
	}
	

}
