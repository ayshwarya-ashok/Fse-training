package com.cognizant.DiagnosticMedicare.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.DiagnosticMedicare.DiagnosticMedicareApplication;
import com.cognizant.DiagnosticMedicare.model.Users;
import com.cognizant.DiagnosticMedicare.repository.AdminRepository;
import com.cognizant.DiagnosticMedicare.repository.PatientRepository;
import com.cognizant.DiagnosticMedicare.repository.DoctorRepository;
import com.cognizant.DiagnosticMedicare.repository.UserRepository;


@Service
public class AppUserDetailsService implements UserDetailsService{

	private static final Logger LOGGER = LoggerFactory.getLogger(DiagnosticMedicareApplication.class);
	
//	@Autowired
//	private AdminRepository adminRepository;
//	
//	@Autowired
//	private CustomerRepository customerRepository;
//	
//	@Autowired
//	private DoctorRepository doctorRepository;
//	
	@Autowired
	private UserRepository userRepository;
	
	
//	public AppUserDetailsService(AdminRepository adminRepository, CustomerRepository customerRepository, DoctorRepository doctorRepository) {
//		
//		 this.adminRepository = adminRepository;
//		 this.customerRepository =  customerRepository;
//		 this.doctorRepository = doctorRepository;
//	}
    public AppUserDetailsService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LOGGER.info("Start");
		System.out.println(username);
		Users user = userRepository.findByUsername(username);
		
		UserDetails appUser = null;
		
		if(user==null) {
			
			throw new UsernameNotFoundException("User Not Found");
			
		} else {
			
			appUser = new AppUser(user);
		
		}
		LOGGER.info("End");
		return appUser;
	}
	
	
	
	

}
