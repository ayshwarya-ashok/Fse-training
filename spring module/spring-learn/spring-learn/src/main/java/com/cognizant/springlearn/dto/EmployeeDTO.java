package com.cognizant.springlearn.dto;



import java.util.Date;
import java.util.Set;

import com.cognizant.springlearn.Department;
import com.cognizant.springlearn.Skill;


public class EmployeeDTO {
	
	private int id;
	
	private String name;
	
	private double salary;
	
	private boolean permanent;
	
	private Date dateOfBirth;
	
	private DepartmentDTO department;
	
	private Set<SkillDTO> skillList;

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(int id, String name, double salary, boolean permanent, Date dateOfBirth, DepartmentDTO department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.permanent = permanent;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
	}

	public EmployeeDTO(int id, String name, double salary, boolean permanent, Date dateOfBirth, DepartmentDTO department,
			Set<SkillDTO> skillList) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.permanent = permanent;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
		this.skillList = skillList;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

	public Set<SkillDTO> getSkillList() {
		return skillList;
	}

	public void setSkillList(Set<SkillDTO> skillList) {
		this.skillList = skillList;
	}

	@Override
	public String toString() {
		return "\nEmployee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateOfBirth=" + dateOfBirth + ", department=" + department + ", skillList=" + skillList + "]";
	}

}


