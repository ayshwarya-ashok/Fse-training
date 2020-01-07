package com.cognizant.DiagnosticMedicare.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.DiagnosticMedicare.DTO.DoctorDTO;
import com.cognizant.DiagnosticMedicare.DTO.MedicareDTO;
import com.cognizant.DiagnosticMedicare.DTO.TestResultNameDTO;
import com.cognizant.DiagnosticMedicare.model.Doctor;
import com.cognizant.DiagnosticMedicare.model.Medicare;
import com.cognizant.DiagnosticMedicare.model.Patient;
import com.cognizant.DiagnosticMedicare.model.Request;
import com.cognizant.DiagnosticMedicare.model.TestResultName;
import com.cognizant.DiagnosticMedicare.model.Users;
import com.cognizant.DiagnosticMedicare.service.AdminService;
import com.cognizant.DiagnosticMedicare.service.MedicareService;
import com.cognizant.DiagnosticMedicare.service.RequestService;

@RestController
@RequestMapping("")

public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private MedicareService medicareService;
	
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		return adminService.getAllUsers();
		
	}
	
	@PutMapping("/edit-users")
	public List<Users> editUsers(@RequestBody Users user){
		return adminService.editUsers(user);
		
	}
	
	@GetMapping("/get-one-user/{id}")
	public Users getOneUser(@PathVariable int id){
		return adminService.getOneUser(id);
		
	}
		
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctorList(){
		return adminService.getAllDoctorList();
		
	}
	
	@GetMapping("/customers")
	public List<Patient> getAllCustomerList(){
		return adminService.getAllCustomerList();
		
	}
	
	@GetMapping("/medicare-services")
	public MedicareDTO[] getAllMedicareList(){
		return transformMedicareToDTO(adminService.getAllMedicareList());
		
	}
	
	@PutMapping("/request-update")
	public boolean acceptRequest(@RequestBody Request request) {
		return requestService.acceptRequest(request);
	}
	
	@GetMapping("/admin-view-request")
	public List<Request> adminRequest(){
		return requestService.adminRequest();	
	}
	
	@PostMapping("/edit-medicare-service")
	public boolean editMedicareService(@RequestBody Medicare medicare) {
		return medicareService.editMedicareService(medicare);
	}
	
	
	private MedicareDTO[] transformMedicareToDTO(List<Medicare> medicare) {

		MedicareDTO[] medicareDTO = new MedicareDTO[medicare.size()];

		int count = 0;

		for (Medicare medi : medicare) {

			medicareDTO[count] = new MedicareDTO();
			
			medicareDTO[count].setId(medi.getId());
			medicareDTO[count].setMedicareService(medi.getMedicareService());
			medicareDTO[count].setServiceDescription(medi.getServiceDescription());
			medicareDTO[count].setAmount(medi.getAmount());
			medicareDTO[count].setAgentCommission(medi.getAgentCommission());
			
			

			

			Set<Doctor> doctorList = medi.getDoctor();

			Set<DoctorDTO> doctorListDto = new HashSet();

			for (Doctor doc : doctorList) {

				DoctorDTO doctorDTO = new DoctorDTO();
				
				
				
				doctorDTO.setDoctorId(doc.getDoctorId());
				doctorDTO.setUserName(doc.getUserName());
				doctorDTO.setFirstName(doc.getFirstName());
				doctorDTO.setLastName(doc.getLastName());
				doctorDTO.setAge(doc.getAge());
				doctorDTO.setGender(doc.getGender());
				doctorDTO.setDateOfBirth(doc.getDateOfBirth());
				doctorDTO.setContactNumber(doc.getContactNumber());
				doctorDTO.setAltContactNumber(doc.getAltContactNumber());
				doctorDTO.setEmailId(doc.getEmailId());
				doctorDTO.setPassword(doc.getPassword());
				doctorDTO.setAddressLineOne(doc.getAddressLineOne());
				doctorDTO.setAddressLineTwo(doc.getAddressLineTwo());
				doctorDTO.setCity(doc.getCity());
				doctorDTO.setState(doc.getState());
				doctorDTO.setZipcode(doc.getZipcode());
				doctorDTO.setDegree(doc.getDegree());
				doctorDTO.setSpeciality(doc.getSpeciality());
				doctorDTO.setWorkhours(doc.getWorkhours());
				doctorDTO.setHospitalName(doc.getHospitalName());
				
				
				doctorListDto.add(doctorDTO);

			}

			medicareDTO[count].setDoctor(doctorListDto);
			
			Set<TestResultName> testResultNameList = medi.getTestResultName();

			Set<TestResultNameDTO> testResultNameDTOList = new HashSet();

			for (TestResultName testName : testResultNameList) {

				TestResultNameDTO testResultNameDTO = new TestResultNameDTO();
				
				testResultNameDTO.setId(testName.getId());
				testResultNameDTO.setNormalRange(testName.getNormalRange());
				testResultNameDTO.setTestName(testName.getTestName());
				testResultNameDTO.setMedicare(null);
				
				
				testResultNameDTOList.add(testResultNameDTO);

			}
			
			medicareDTO[count].setTestResultName(testResultNameDTOList);

			count++;

		}

		return medicareDTO;

	}
}
