package com.cognizant.DiagnosticMedicare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.DiagnosticMedicare.model.Request;


@Repository
public interface RequestRepository  extends JpaRepository<Request, Integer> {
	
	@Query(nativeQuery=true, value="select * from request where re_active='Sent'")
	List<Request> adminRequest();
	
	@Query(nativeQuery=true, value="select * from request where re_active='Pending' or re_active='Accepted'")
	List<Request> doctorRequest();
	
	@Query(nativeQuery=true, value="select * from request where pa_id=?1")
	List<Request> customerRequest(int customerId);
}
