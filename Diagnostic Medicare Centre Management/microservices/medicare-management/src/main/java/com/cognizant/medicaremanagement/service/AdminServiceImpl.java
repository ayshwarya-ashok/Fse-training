package com.cognizant.medicaremanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.medicaremanagement.model.Customer;
import com.cognizant.medicaremanagement.model.Doctor;
import com.cognizant.medicaremanagement.model.Medicare;
import com.cognizant.medicaremanagement.repository.AdminRepository;
import com.cognizant.medicaremanagement.repository.CustomerRepository;
import com.cognizant.medicaremanagement.repository.DoctorRepository;
import com.cognizant.medicaremanagement.repository.MedicareRepository;
import com.cognizant.medicaremanagement.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	MedicareRepository medicareRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public List<Doctor> getAllDoctorList() {

		return doctorRepository.findAll();
	}

	@Override
	public List<Customer> getAllCustomerList() {

		return customerRepository.findAll();
	}

	@Override
	public List<Medicare> getAllMedicareList() {

		return medicareRepository.findAll();
	}

	@Override
	public List<Customer> removeCustomer(String userName) {
		Customer customer = customerRepository.findByUserName(userName);		
		customerRepository.delete(customer);
		System.out.println(customerRepository.findAll());
		return customerRepository.findAll();	}

	@Override
	public List<Doctor> removeDoctor(String userName) {
		Doctor doctor = doctorRepository.findByUserName(userName);
		doctorRepository.delete(doctor);	
		return doctorRepository.findAll();
	}

}
