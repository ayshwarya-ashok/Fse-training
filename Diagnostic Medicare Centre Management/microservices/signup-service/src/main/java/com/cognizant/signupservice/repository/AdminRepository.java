package com.cognizant.signupservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.signupservice.model.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	public Admin findByUserName(String userName); 
}
