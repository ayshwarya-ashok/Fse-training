package com.cognizant.DiagnosticMedicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.DiagnosticMedicare.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	Doctor findByUserName(String userName);
}
