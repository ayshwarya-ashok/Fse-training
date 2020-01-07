package com.cognizant.employee.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;

public class SkillDTO {
	private int id;
	
	private String name;
	private Set<EmployeeDTO> employeeList;

	public SkillDTO(int id, String name, Set<EmployeeDTO> employeeList) {
		this.id = id;
		this.name = name;
		this.employeeList = employeeList;
	}

	public Set<EmployeeDTO> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Set<EmployeeDTO> employeeList) {
		this.employeeList = employeeList;
	}

	public SkillDTO() {

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

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}
}
