package com.cognizant.springWar.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springWar.dao.StudentDao;
import com.cognizant.springWar.exception.StudentNotFoundException;
import com.cognizant.springWar.model.Students;

@RestController
@RequestMapping("/api")
/* @CrossOrigin("http://localhost:4200") */

public class Controller {

	@Autowired
	StudentDao studentDao;
	@GetMapping("/students")
	public List<Students> getAllStudents(){
		return studentDao.getAllStudents();
	}
	
	@PostMapping("/students")
	public List<Students> addStudent(@RequestBody @Valid Students student){
		return studentDao.addStudent(student);
		
	}
	
	@PutMapping("/students")
	public List<Students> updateStudent(@RequestBody @Valid Students student){
		return studentDao.updateStudent(student);
	}
	
	@DeleteMapping("/students/{id}")
	public List<Students> deleteStudent(@PathVariable int id) throws StudentNotFoundException {
		studentDao.deleteStudent(id);
		return studentDao.getAllStudents();
	}
	@GetMapping("/students/{id}")
	public Students getOneStudent(@PathVariable int id) {
		return studentDao.getOneStudent(id);
	}
}
