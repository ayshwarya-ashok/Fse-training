package com.cognizant.employee.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.employee.model.Department;
@Repository
public interface DepartmentRepository  extends JpaRepository<Department, Integer> {

}
