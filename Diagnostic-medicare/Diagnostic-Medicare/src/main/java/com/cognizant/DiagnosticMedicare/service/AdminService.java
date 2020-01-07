package com.cognizant.DiagnosticMedicare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.DiagnosticMedicare.model.Doctor;
import com.cognizant.DiagnosticMedicare.model.Medicare;
import com.cognizant.DiagnosticMedicare.model.Patient;
import com.cognizant.DiagnosticMedicare.model.Users;

@Service
public interface AdminService {
	
public List<Doctor> getAllDoctorList();
	
	public List<Patient> getAllCustomerList();
	
	public List<Medicare> getAllMedicareList();
	
	public List<Users> getAllUsers();

	public List<Users> editUsers(Users user);
	
	public Users getOneUser(int id);
}
