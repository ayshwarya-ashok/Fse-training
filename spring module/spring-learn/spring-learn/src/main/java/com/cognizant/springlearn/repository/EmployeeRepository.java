package com.cognizant.springlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.springlearn.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
