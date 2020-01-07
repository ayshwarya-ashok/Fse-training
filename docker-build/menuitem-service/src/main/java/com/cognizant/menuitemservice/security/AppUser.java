package com.cognizant.menuitemservice.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import com.cognizant.menuitemservice.model.Users;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class AppUser implements UserDetails{
	
	private Users users; 
    private Collection<? extends GrantedAuthority> authorities; 
    
    
	public AppUser(Users users) {
		this.users = users;
		this.authorities = users.getRoleList()
							   .stream()
                			   .map(role -> new SimpleGrantedAuthority(role.getRole()))
                			   .collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return this.authorities;
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

