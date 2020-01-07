package com.cognizant.medicaremanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.medicaremanagement.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
	public Users findByUserName(String userName);

	
}
