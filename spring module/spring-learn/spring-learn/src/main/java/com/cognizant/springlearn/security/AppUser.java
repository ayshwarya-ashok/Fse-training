package com.cognizant.springlearn.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.cognizant.springlearn.User;

public class AppUser implements UserDetails{
	
	private User user; 
    private Collection<? extends GrantedAuthority> authorities; 
    
    
	public AppUser(User user) {
		this.user = user;
		this.authorities = user.getRoleList()
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
		
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
	
		return this.user.getUserName();
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
