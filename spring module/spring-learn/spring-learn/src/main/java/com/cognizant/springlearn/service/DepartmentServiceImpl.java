package com.cognizant.springlearn.service;


import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Department;
import com.cognizant.springlearn.repository.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService{
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Transactional
	public Department get(int id) {
		LOGGER.info("Start");
		return departmentRepository.findById(id).get();
	}

	
}