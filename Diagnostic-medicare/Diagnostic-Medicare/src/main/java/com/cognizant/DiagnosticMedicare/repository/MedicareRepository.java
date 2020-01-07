package com.cognizant.DiagnosticMedicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.DiagnosticMedicare.model.Admin;
import com.cognizant.DiagnosticMedicare.model.Medicare;

@Repository
public interface MedicareRepository extends JpaRepository<Medicare, Integer>{
	

}
