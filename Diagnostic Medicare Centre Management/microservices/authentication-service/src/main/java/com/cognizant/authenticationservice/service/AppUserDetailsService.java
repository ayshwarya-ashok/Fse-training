package com.cognizant.authenticationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.authenticationservice.model.Users;
import com.cognizant.authenticationservice.repository.UserRepository;
import com.cognizant.authenticationservice.security.AppUser;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	AppUser newUser = null;

	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = userRepository.findByUserName(username);
		if (users == null) {
			throw new UsernameNotFoundException("User not found!!!");
		} else {
			newUser = new AppUser(users);
		}
		return newUser;
	}

}
