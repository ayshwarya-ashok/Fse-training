package com.cognizant.DiagnosticMedicare.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.DiagnosticMedicare.exception.UserAlreadyExistsException;
import com.cognizant.DiagnosticMedicare.model.Admin;
import com.cognizant.DiagnosticMedicare.model.Agent;
import com.cognizant.DiagnosticMedicare.model.Doctor;
import com.cognizant.DiagnosticMedicare.model.Patient;
import com.cognizant.DiagnosticMedicare.model.Role;
import com.cognizant.DiagnosticMedicare.model.Users;
import com.cognizant.DiagnosticMedicare.repository.AdminRepository;
import com.cognizant.DiagnosticMedicare.repository.AgentRepository;
import com.cognizant.DiagnosticMedicare.repository.DoctorRepository;
import com.cognizant.DiagnosticMedicare.repository.PatientRepository;
import com.cognizant.DiagnosticMedicare.repository.RoleRepository;



@Service
public class SignUpServiceImpl implements SignUpService {
		
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	AgentRepository agentRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder bCryptPasswordEncoder;

	private static final Logger LOGGER = LoggerFactory.getLogger(SignUpService.class);

	@Transactional
	public void patientSignup(Patient patient) throws UserAlreadyExistsException {
		LOGGER.info("START");
		if (patientRepository.findByUsername(patient.getUsername()) == null) {
			LOGGER.debug("NEW PATIENT SIGNUP");
			Patient newPatient = new Patient();
			newPatient.setAddressLineOne(patient.getAddressLineOne());
			newPatient.setAddressLineTwo(patient.getAddressLineTwo());
			newPatient.setAge(patient.getAge());
			newPatient.setAltContactNumber(patient.getAltContactNumber());
			newPatient.setCity(patient.getCity());
			newPatient.setContactNumber(patient.getContactNumber());
			newPatient.setDateOfBirth(patient.getDateOfBirth());
			newPatient.setEmailId(patient.getEmailId());
			newPatient.setFirstName(patient.getFirstName());
			newPatient.setGender(patient.getGender());
			newPatient.setId(patient.getId());
			newPatient.setLastName(patient.getLastName());
			newPatient.setPassword(bCryptPasswordEncoder.encode(patient.getPassword()));
			newPatient.setSecurityQuestion(patient.getSecurityQuestion());
			newPatient.setSecurityAnswer(patient.getSecurityAnswer());
			newPatient.setState(patient.getState());
			newPatient.setUsername(patient.getUsername());
			newPatient.setZipcode(patient.getZipcode());
			Users newUser = new Users();
			newUser.setUsername(patient.getUsername());
			newUser.setPassword(bCryptPasswordEncoder.encode(patient.getPassword()));
			newUser.setApprove("PENDING");
			Role role = new Role(0, "PATIENT");
			newUser.setRole(role);
			newPatient.setUser(newUser);
			LOGGER.debug("NEW PATIENT DETAILS: {}", newPatient);
			patientRepository.save(newPatient);
		} else {
			LOGGER.debug("USER ALREADY EXIST EXCEPTION");
			throw new UserAlreadyExistsException();
		}
		LOGGER.info("END");
	}
	
	@Transactional
	public void adminSignup(Admin admin) throws UserAlreadyExistsException {
		LOGGER.info("START");
		if (adminRepository.findByUsername(admin.getUsername()) == null) {
			LOGGER.debug("NEW ADMIN SIGNUP");
			Admin newAdmin = new Admin();
			newAdmin.setAge(admin.getAge());
			newAdmin.setAltContactNumber(admin.getAltContactNumber());
			newAdmin.setContactNumber(admin.getContactNumber());
			newAdmin.setDateOfBirth(admin.getDateOfBirth());
			newAdmin.setEmailId(admin.getEmailId());
			newAdmin.setFirstName(admin.getFirstName());
			newAdmin.setGender(admin.getGender());
			newAdmin.setId(admin.getId());
			newAdmin.setLastName(admin.getLastName());
			newAdmin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
			newAdmin.setUsername(admin.getUsername());
		
			Users newUser = new Users();
			newUser.setUsername(admin.getUsername());
			newUser.setApprove("ACCEPTED");
			System.out.println(admin.getUsername());
			newUser.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
			Role role = new Role(0, "ADMIN");
			newUser.setRole(role);
			newAdmin.setUser(newUser);
			LOGGER.debug("NEW ADMIN DETAILS: {}", newAdmin);
			adminRepository.save(newAdmin);
		} else {
			LOGGER.debug("USER ALREADY EXIST EXCEPTION");
			throw new UserAlreadyExistsException();
		}
		LOGGER.info("END");
	}
	

	@Transactional
	public void doctorSignup(Doctor doctor) throws UserAlreadyExistsException {
		LOGGER.info("START");
		System.out.println(doctor.getSecurityAnswer()+"ANswer");
		if (doctorRepository.findByUserName(doctor.getUserName()) == null) {
			LOGGER.debug("NEW PATIENT SIGNUP");
		    Doctor newDoctor = new Doctor();
		    newDoctor.setAddressLineOne(doctor.getAddressLineOne());
		    newDoctor.setAddressLineTwo(doctor.getAddressLineTwo());
		    newDoctor.setAge(doctor.getAge());
		    newDoctor.setAltContactNumber(doctor.getAltContactNumber());
		    newDoctor.setCity(doctor.getCity());
		    newDoctor.setContactNumber(doctor.getContactNumber());
		    newDoctor.setDateOfBirth(doctor.getDateOfBirth());
		    newDoctor.setEmailId(doctor.getEmailId());
		    newDoctor.setFirstName(doctor.getFirstName());
		    newDoctor.setGender(doctor.getGender());
		    newDoctor.setDoctorId(doctor.getDoctorId());
		    newDoctor.setLastName(doctor.getLastName());
		    newDoctor.setPassword(bCryptPasswordEncoder.encode(doctor.getPassword()));
			newDoctor.setSecurityQuestion(doctor.getSecurityQuestion());
		    newDoctor.setSecurityAnswer(doctor.getSecurityAnswer());
		    newDoctor.setState(doctor.getState());
		    newDoctor.setUserName(doctor.getUserName());
		    newDoctor.setZipcode(doctor.getZipcode());
		    newDoctor.setSpeciality(doctor.getSpeciality());
		    newDoctor.setHospitalName(doctor.getHospitalName());
		    newDoctor.setWorkhours(doctor.getWorkhours());
		    newDoctor.setDegree(doctor.getDegree());
		 
			Users newUser = new Users();
			newUser.setUsername(doctor.getUserName());
			newUser.setPassword(bCryptPasswordEncoder.encode(doctor.getPassword()));
			newUser.setApprove("PENDING");
			Role role = new Role(0, "DOCTOR");
			newUser.setRole(role);
			newDoctor.setUser(newUser);
			LOGGER.debug("NEW PATIENT DETAILS: {}", newDoctor);
			doctorRepository.save(newDoctor);
			
		} else {
			LOGGER.debug("USER ALREADY EXIST EXCEPTION");
			throw new UserAlreadyExistsException();
		}
		LOGGER.info("END");
	}
	@Override
	@Transactional
	public void agentSignup(Agent agent) throws UserAlreadyExistsException {
		LOGGER.info("START");
		if (patientRepository.findByUsername(agent.getUsername()) == null) {
			LOGGER.debug("NEW AGENT SIGNUP");
			Agent newAgent = new Agent();
			newAgent.setAddressLineOne(agent.getAddressLineOne());
			newAgent.setAddressLineTwo(agent.getAddressLineTwo());
			newAgent.setAge(agent.getAge());
			newAgent.setAltContactNumber(agent.getAltContactNumber());
			newAgent.setCity(agent.getCity());
			newAgent.setContactNumber(agent.getContactNumber());
			newAgent.setDateOfBirth(agent.getDateOfBirth());
			newAgent.setEmailId(agent.getEmailId());
			newAgent.setFirstName(agent.getFirstName());
			newAgent.setGender(agent.getGender());
			newAgent.setId(agent.getId());
			newAgent.setLastName(agent.getLastName());
			newAgent.setPassword(bCryptPasswordEncoder.encode(agent.getPassword()));
			newAgent.setSecurityQuestion(agent.getSecurityQuestion());
			newAgent.setSecurityAnswer(agent.getSecurityAnswer());
			newAgent.setState(agent.getState());
			newAgent.setUsername(agent.getUsername());
			newAgent.setZipcode(agent.getZipcode());
			Users newUser = new Users();
			newUser.setUsername(agent.getUsername());
			newUser.setPassword(bCryptPasswordEncoder.encode(agent.getPassword()));
			newUser.setApprove("PENDING");
			Role role = new Role(0, "AGENT");
			newUser.setRole(role);
			newAgent.setUser(newUser);
			LOGGER.debug("NEW AGENT DETAILS: {}", newAgent);
			agentRepository.save(newAgent);
		} else {
			LOGGER.debug("USER ALREADY EXIST EXCEPTION");
			throw new UserAlreadyExistsException();
		}
		LOGGER.info("END");
		
	}

	@Override
	public boolean doctorUpdate(Doctor doctor) {
		doctor.setPassword(bCryptPasswordEncoder.encode(doctor.getPassword()));
		doctorRepository.save(doctor);
		return true;
	}

	@Override
	public boolean customerUpdate(Patient patient) {
		
		patient.setPassword(bCryptPasswordEncoder.encode(patient.getPassword()));
		patient.getUser().setPassword(patient.getPassword());
		
		patientRepository.save(patient);
		return true;
	}
}
