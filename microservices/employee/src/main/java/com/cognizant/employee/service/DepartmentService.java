package com.cognizant.employee.service;

import org.springframework.stereotype.Service;

import com.cognizant.employee.model.Department;
@Service
public interface DepartmentService {
	Department get(int id);
}
