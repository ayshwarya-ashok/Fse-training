package com.cognizant.springlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.springlearn.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
