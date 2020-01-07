package com.cognizant.employee.dto;

import java.util.Set;

public class DepartmentDTO {
	private int id;

	private String name;

	// @JsonBackReference
	private Set<EmployeeDTO> employeeList;

	public DepartmentDTO() {

	}

	public DepartmentDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Set<EmployeeDTO> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Set<EmployeeDTO> employeeList) {
		this.employeeList = employeeList;
	}

	public DepartmentDTO(int id, String name, Set<EmployeeDTO> employeeList) {
		super();
		this.id = id;
		this.name = name;
		this.employeeList = employeeList;
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
		return "Department [id=" + id + ", name=" + name + ",]";
	}

}
