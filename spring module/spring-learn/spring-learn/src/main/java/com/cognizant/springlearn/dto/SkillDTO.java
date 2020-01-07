package com.cognizant.springlearn.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.cognizant.springlearn.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;

public class SkillDTO {
	
	private int id;
	
	private String name;
	
	private Set<Employee> employeeList;

	public SkillDTO() {
		super();
	}

	public SkillDTO(int id, String name, Set<Employee> employeeList) {
		super();
		this.id = id;
		this.name = name;
		this.employeeList = employeeList;
	}
	
	public SkillDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Set<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}
}
