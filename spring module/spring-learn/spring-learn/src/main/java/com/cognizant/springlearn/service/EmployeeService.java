package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Employee;



@Service
public interface EmployeeService {
	Employee get(int id);
	void save(Employee employee);
//	List<Employee> getAllPermanentEmployees();
	List<Employee> getAllEmployees();
}