package com.cognizant.ormlearn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.ormlearn.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	//@Query(value="SELECT e FROM Employee e WHERE e.permanent = 1")
	@Query(value="SELECT e FROM Employee e left join e.department d left join e.skillList WHERE e.permanent = 1")
    List<Employee> getAllPermanentEmployees();
}
