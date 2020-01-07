package com.cognizant.employee.service;

import java.util.List;

import com.cognizant.employee.model.Employee;

public interface EmployeeService {
	Employee get(int id);
	void save(Employee employee);
	List<Employee> getAllPermanentEmployees();
	List<Employee> getAllEmployees();
}
