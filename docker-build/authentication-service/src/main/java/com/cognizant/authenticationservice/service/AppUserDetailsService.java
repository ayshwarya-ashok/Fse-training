package com.cognizant.authenticationservice.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.authenticationservice.model.Role;
import com.cognizant.authenticationservice.model.Users;
import com.cognizant.authenticationservice.repository.UserRepository;
import com.cognizant.authenticationservice.security.AppUser;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder encoder;
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

	public void signup(Users user) throws UserAlreadyExistsException {
		Users users = userRepository.findByUserName(user.getUserName());
		if (users != null) {
			throw new UserAlreadyExistsException("Existing user!");

		} else {
			String encodedPassword = encoder.encode(user.getPassword());
			Set<Role> roleList = new HashSet<Role>();
			roleList.add(new Role(2, "user"));
			user = new Users(0, user.getUserName(), user.getFirstName(), user.getLastName(), encodedPassword, null,
					roleList);
			userRepository.save(user);
		}
	}
}
