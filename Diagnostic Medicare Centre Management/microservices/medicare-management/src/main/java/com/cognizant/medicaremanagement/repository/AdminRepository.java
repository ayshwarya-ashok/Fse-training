package com.cognizant.medicaremanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.medicaremanagement.model.Admin;



@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	public Admin findByUserName(String userName); 

}
