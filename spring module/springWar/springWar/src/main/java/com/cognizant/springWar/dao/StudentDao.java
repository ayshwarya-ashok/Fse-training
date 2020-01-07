package com.cognizant.springWar.dao;

import java.util.List;

import com.cognizant.springWar.exception.StudentNotFoundException;
import com.cognizant.springWar.model.Students;

public interface StudentDao {
	public List<Students> getAllStudents();
	public void deleteStudent(int id) throws StudentNotFoundException;
	public List<Students> updateStudent(Students student);
	public List<Students> addStudent(Students student);
	public Students getOneStudent(int id);
}
