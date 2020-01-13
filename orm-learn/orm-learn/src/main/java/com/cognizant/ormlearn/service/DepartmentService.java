package com.cognizant.ormlearn.service;

import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Department;

@Service
public interface DepartmentService {
	Department get(int id);
}
