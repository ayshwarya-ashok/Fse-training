package com.cognizant.DiagnosticMedicare.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.DiagnosticMedicare.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
	Users findByUsername(String name);
	Users findById(int id);
	
	@Query(nativeQuery=true, value="select * from user where us_approve='PENDING'")
	List<Users> getAllUsers();
	
}

