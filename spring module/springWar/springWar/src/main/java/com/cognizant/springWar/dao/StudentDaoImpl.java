package com.cognizant.springWar.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.springWar.exception.StudentNotFoundException;
import com.cognizant.springWar.model.Students;
@Repository
public class StudentDaoImpl implements StudentDao{
	
	List<Students> studentsList;
	
	

	public StudentDaoImpl() {
		studentsList = new ArrayList<>();
		studentsList.add(new Students(1,"Ayshu",95));
		studentsList.add(new Students(2,"Sethulakshmi",96));
		studentsList.add(new Students(3,"Anusha",97));
		studentsList.add(new Students(4,"Haripriya",98));
		studentsList.add(new Students(5,"Jaya",99));
		
	}

	@Override
	public List<Students> getAllStudents() {
		
		return studentsList;
	}

	@Override
	public void deleteStudent(int id) throws StudentNotFoundException {
		boolean status =false;
		for(Students student: studentsList) {
			if(student.getId() == id ) {
				int index = studentsList.indexOf(student);
				studentsList.remove(index);
				status =true;
				break;
			}
		}
		if(status ==false) {
			throw new StudentNotFoundException("This "+id+ "not found");
		}
		
	}

	@Override
	public List<Students> updateStudent(Students student) {
		for(Students stu: studentsList) {
			if(stu.getId() == student.getId()) {
				stu.setSname(student.getSname());
				stu.setMarks(student.getMarks());
			}
		}
		return studentsList;
	}

	@Override
	public Students getOneStudent(int id) {
		Students student = null; 
		for(int i = 0; i<studentsList.size(); i++) {
			if(studentsList.get(i).getId() == id) {
				student =  studentsList.get(i);
			}
		}
		return student;
		
	}

	@Override
	public List<Students> addStudent(Students student) {
		int size = studentsList.size();
		int lastid = studentsList.get(size-1).getId();
		studentsList.add(new Students(lastid+1, student.getSname(), student.getMarks()));
		return studentsList;
	}

}
