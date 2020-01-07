package com.cognizant.medicaremanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.medicaremanagement.model.Request;




@Repository
public interface RequestRepository  extends JpaRepository<Request, Integer> {
	
	@Query(nativeQuery=true, value="select * from request where re_active=0")
	List<Request> adminRequest();
	
	@Query(nativeQuery=true, value="select * from request where re_active=1")
	List<Request> doctorRequest();
	
	@Query(nativeQuery=true, value="select * from request where re_customer_name=?1")
	List<Request> customerRequest(String customerName);
	
}
