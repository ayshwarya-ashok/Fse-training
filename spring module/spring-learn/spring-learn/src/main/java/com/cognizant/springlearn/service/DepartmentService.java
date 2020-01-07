package com.cognizant.springlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Department;
import com.cognizant.springlearn.Employee;



@Service
public interface DepartmentService {
	Department get(int id);
	
}

