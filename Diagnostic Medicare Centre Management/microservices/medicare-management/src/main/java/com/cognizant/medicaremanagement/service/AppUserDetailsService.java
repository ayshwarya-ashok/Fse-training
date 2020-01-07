package com.cognizant.medicaremanagement.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.medicaremanagement.model.Users;
import com.cognizant.medicaremanagement.repository.UserRepository;
import com.cognizant.medicaremanagement.security.AppUser;



@Service
public class AppUserDetailsService implements UserDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);

	@Autowired
	UserRepository userRepository;
	
	AppUser newUser = null;

	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.info("Start");
		System.out.println(username);
		Users user = userRepository.findByUserName(username);
		
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
