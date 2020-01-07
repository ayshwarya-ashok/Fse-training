package com.cognizant.medicaremanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.medicaremanagement.model.Doctor;



@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	public Doctor findByUserName(String userName); 
}
