package com.cognizant.authenticationservice.security;

import java.util.Collection;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognizant.authenticationservice.model.Users;

public class AppUser implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users users; 
    private Collection<? extends GrantedAuthority> authorities; 
    
    
	public AppUser(Users users) {
		this.users = users;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}

	@Override
	public String getPassword() {
		
		return this.users.getPassword();
	}

	@Override
	public String getUsername() {
	
		return this.users.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}

