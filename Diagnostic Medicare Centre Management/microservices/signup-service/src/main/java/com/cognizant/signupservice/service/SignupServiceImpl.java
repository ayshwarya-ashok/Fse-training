package com.cognizant.signupservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cognizant.signupservice.exception.UserAlreadyExistsException;
import com.cognizant.signupservice.model.Admin;
import com.cognizant.signupservice.model.Customer;
import com.cognizant.signupservice.model.Doctor;
import com.cognizant.signupservice.model.Role;
import com.cognizant.signupservice.model.Users;
import com.cognizant.signupservice.repository.AdminRepository;
import com.cognizant.signupservice.repository.CustomerRepository;
import com.cognizant.signupservice.repository.DoctorRepository;

@Service
public class SignupServiceImpl implements SignupService{
	
	@Autowired 
	CustomerRepository customerRepository;
	@Autowired 
	DoctorRepository doctorRepository;
	@Autowired 
	AdminRepository adminRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	public void customerSignup(Customer customer) throws UserAlreadyExistsException {
		Customer cus = customerRepository.findByUserName(customer.getUserName());
		Users user;
		if (cus != null) {
			throw new UserAlreadyExistsException("Existing user!");

		} else {
			String encodedPassword = encoder.encode(customer.getPassword());
			Role role = new Role(0, "customer");
			user = new Users(0, customer.getUserName(), customer.getFirstName(), encodedPassword, role);
			Customer newCustomer = new Customer(0,customer.getUserName(), customer.getFirstName(), customer.getLastName(), customer.getAge(), customer.getGender(),
					customer.getDateOfBirth(), customer.getContactNumber(), customer.getAltContactNumber(), customer.getEmailId(), customer.getPassword(),
					customer.getAddressLine_1(), customer.getAddressLine_2(), customer.getCity(), customer.getState(), customer.getZipCode(), user);
			customerRepository.save(newCustomer);
		}
	}

	public void doctorSignup(Doctor doctor) throws UserAlreadyExistsException {
		Doctor doc = doctorRepository.findByUserName(doctor.getUserName());
		Users user;
		if (doc != null) {
			throw new UserAlreadyExistsException("Existing user!");

		} else {
			String encodedPassword = encoder.encode(doctor.getPassword());
			Role role = new Role(1, "doctor");
			user = new Users(0, doctor.getUserName(), doctor.getFirstName(), encodedPassword, role);
			Doctor newDoc = new Doctor(0,doctor.getUserName(), doctor.getFirstName(), doctor.getLastName(), doctor.getAge(), doctor.getGender(),
					doctor.getDateOfBirth(), doctor.getContactNumber(), doctor.getAltContactNumber(), doctor.getEmailId(), doctor.getPassword(),
					doctor.getAddressLine_1(), doctor.getAddressLine_2(), doctor.getCity(), doctor.getState(), doctor.getZipCode(), doctor.getDegree(), 
					doctor.getSpeciality(), doctor.getWorkHours(), doctor.getHospitalName(), doctor.getMedicareList(), user);
			doctorRepository.save(newDoc);
		}
	}
	
	public void adminSignup(Admin admin) throws UserAlreadyExistsException {
		Admin oldAdmin= adminRepository.findByUserName(admin.getUserName());
		Users user;
		if (oldAdmin != null) {
			throw new UserAlreadyExistsException("Existing user!");

		} else {
			String encodedPassword = encoder.encode(admin.getPassword());
			Role role = new Role(1, "admin");
			user = new Users(0, admin.getUserName(), admin.getFirstName(), encodedPassword, role);
			Admin newAdmin = new Admin(0,admin.getUserName(), admin.getFirstName(), admin.getLastName(), admin.getAge(), admin.getGender(),
					admin.getDateOfBirth(), admin.getContactNumber(), admin.getAltContactNumber(), admin.getEmailId(), admin.getPassword(), user);
			adminRepository.save(newAdmin);
		}
	}
	
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}

}
