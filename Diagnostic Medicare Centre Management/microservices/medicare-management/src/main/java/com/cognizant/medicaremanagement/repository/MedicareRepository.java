package com.cognizant.medicaremanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.medicaremanagement.model.Medicare;


@Repository
public interface MedicareRepository extends JpaRepository<Medicare, Integer>{
	

}
