package com.cognizant.employee.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dp_id")
	private int id;
	@Column(name = "dp_name")
	private String name;
	@OneToMany(mappedBy = "department")
	//@JsonBackReference
	private Set<Employee> employeeList;

	public Department() {

	}

	

	public Set<Employee> getEmployeeList() {
		return employeeList;
	}



	public void setEmployeeList(Set<Employee> employeeList) {
		this.employeeList = employeeList;
	}



	public Department(int id, String name, Set<Employee> employeeList) {
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
