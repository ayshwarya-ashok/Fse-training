package com.cognizant.signupservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.signupservice.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
	public Users findByUserName(String userName);

	
}
