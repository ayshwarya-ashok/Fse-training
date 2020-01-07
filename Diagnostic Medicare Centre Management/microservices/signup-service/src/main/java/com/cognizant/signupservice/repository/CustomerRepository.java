package com.cognizant.signupservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.signupservice.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	public Customer findByUserName(String userName); 
}
