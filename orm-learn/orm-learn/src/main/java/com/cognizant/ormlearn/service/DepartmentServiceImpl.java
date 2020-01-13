package com.cognizant.ormlearn.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.dao.DepartmentRepository;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;

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
