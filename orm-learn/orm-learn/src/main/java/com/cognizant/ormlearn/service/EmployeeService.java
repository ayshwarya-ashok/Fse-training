package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Employee;

@Service
public interface EmployeeService {
	Employee get(int id);
	void save(Employee employee);
	List<Employee> getAllPermanentEmployees();
}
