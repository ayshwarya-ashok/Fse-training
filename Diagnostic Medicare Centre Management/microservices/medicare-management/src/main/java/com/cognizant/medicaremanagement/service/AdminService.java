package com.cognizant.medicaremanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.medicaremanagement.model.Customer;
import com.cognizant.medicaremanagement.model.Doctor;
import com.cognizant.medicaremanagement.model.Medicare;

@Service
public interface AdminService {
	
	public List<Doctor> getAllDoctorList();
	
	public List<Customer> getAllCustomerList();
	
	public List<Medicare> getAllMedicareList();
	
	public List<Doctor> removeDoctor(String userName);
	
	public List<Customer> removeCustomer(String userName);
}
