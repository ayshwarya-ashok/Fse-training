package com.cognizant.employee.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.employee.dao.UserRepository;
import com.cognizant.employee.model.User;
@Service
public class AppUserDetailsService implements UserDetailsService {
	//private UserRepository repository;
	@Autowired
	UserRepository userRepository;

	public AppUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser;
		User user=userRepository.findByUserName(username);
		if(user==null) {
			
			throw new UsernameNotFoundException("User not found");
		}
		else {
			appUser=new AppUser(user);
		}
		return appUser;
	}

}
