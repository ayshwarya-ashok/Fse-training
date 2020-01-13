package com.cognizant.ormlearn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.OrmLearnApplication;
import com.cognizant.ormlearn.dao.EmployeeRepository;
import com.cognizant.ormlearn.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Autowired
	EmployeeRepository employeeRepository;

	@Transactional
	public Employee get(int id) {
		LOGGER.info("Start");
		return employeeRepository.findById(id).get();
	}

	@Transactional
	public void save(Employee employee) {
		LOGGER.info("Start");
		employeeRepository.save(employee);
		LOGGER.info("End");
	}

	@Override
	public List<Employee> getAllPermanentEmployees() {
		
		return employeeRepository.getAllPermanentEmployees();
	}
	
	
}
