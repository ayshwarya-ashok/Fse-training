package com.cognizant.DiagnosticMedicare.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.DiagnosticMedicare.DTO.DoctorDTO;
import com.cognizant.DiagnosticMedicare.model.Doctor;
import com.cognizant.DiagnosticMedicare.model.Patient;
import com.cognizant.DiagnosticMedicare.model.Request;
import com.cognizant.DiagnosticMedicare.model.TestResult;
import com.cognizant.DiagnosticMedicare.service.AdminService;
import com.cognizant.DiagnosticMedicare.service.RequestService;
import com.cognizant.DiagnosticMedicare.service.TestResultService;

@RestController
@RequestMapping("")

public class CustomerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private TestResultService testResultService;
	
	
	
	@GetMapping("/customer-view-request/{customerId}")
	public List<Request> customerRequest(@PathVariable int customerId){
		return requestService.customerRequest(customerId);	
	}

	@PostMapping("/request")
	public void addRequest(@RequestBody Request request){
		requestService.addRequest(request);
	}
	
	@GetMapping("/get-one-customer/{customerName}")
	public Patient getOneCustomer(@PathVariable String customerName){
		
		return requestService.getOneCustomer(customerName);
	}
	
	@GetMapping("/get-one-doctor/{doctorName}")
	public DoctorDTO getOneDoctor(@PathVariable String doctorName){
		return transformMedicareToDTO(requestService.getOneDoctor(doctorName));
	}

	@PostMapping("/book-appointment")
	public boolean bookAppointment(@RequestBody Request request) {
		LOGGER.info("Start");
		LOGGER.info("End");
		
		return requestService.bookAppointment(request);
	
	}
	
	@GetMapping("/get-test-result/{requestId}")
	public TestResult getOneDoctor(@PathVariable int requestId){
		return testResultService.getTestResult(requestId);
	}
	
	private DoctorDTO transformMedicareToDTO(Doctor doctor) {
			
				DoctorDTO doctorDTO = new DoctorDTO();
				doctorDTO.setDoctorId(doctor.getDoctorId());
				doctorDTO.setUserName(doctor.getUserName());
				doctorDTO.setFirstName(doctor.getFirstName());
				doctorDTO.setLastName(doctor.getLastName());
				doctorDTO.setAge(doctor.getAge());
				doctorDTO.setGender(doctor.getGender());
				doctorDTO.setDateOfBirth(doctor.getDateOfBirth());
				doctorDTO.setContactNumber(doctor.getContactNumber());
				doctorDTO.setAltContactNumber(doctor.getAltContactNumber());
				doctorDTO.setEmailId(doctor.getEmailId());
				doctorDTO.setPassword(doctor.getPassword());
				doctorDTO.setAddressLineOne(doctor.getAddressLineOne());
				doctorDTO.setAddressLineTwo(doctor.getAddressLineTwo());
				doctorDTO.setCity(doctor.getCity());
				doctorDTO.setState(doctor.getState());
				doctorDTO.setZipcode(doctor.getZipcode());
				doctorDTO.setDegree(doctor.getDegree());
				doctorDTO.setSpeciality(doctor.getSpeciality());
				doctorDTO.setWorkhours(doctor.getWorkhours());
				doctorDTO.setHospitalName(doctor.getHospitalName());
				doctorDTO.setMedicareList(null);
		return doctorDTO;

	}
}
