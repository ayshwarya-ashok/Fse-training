package com.cognizant.springlearn.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.Skill;
import com.cognizant.springlearn.dto.DepartmentDTO;
import com.cognizant.springlearn.dto.EmployeeDTO;
import com.cognizant.springlearn.dto.SkillDTO;
import com.cognizant.springlearn.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping("")
	public EmployeeDTO[] getAllEmployees() {
		//return employeeService.getAllEmployees();
		return transformEmployeeToDTO(employeeService.getAllEmployees());
	}
	private EmployeeDTO[] transformEmployeeToDTO(List<Employee> employee) {
		 EmployeeDTO[] empDto= new EmployeeDTO[employee.size()]; 
		 int count = 0;
		 for(Employee emp: employee) {
			 System.out.println(emp);
			 System.out.println(emp.getId());
			 empDto[count].setId(emp.getId());
			 empDto[count].setName(emp.getName());
			 empDto[count].setDateOfBirth(emp.getDateOfBirth());
			 empDto[count].setPermanent(emp.isPermanent());
			 empDto[count].setSalary(emp.getSalary());
			 DepartmentDTO deptDto = new DepartmentDTO(emp.getDepartment().getId(), emp.getDepartment().getName());
			 empDto[count].setDepartment(deptDto);
			 Set<Skill> skillList = emp.getSkillList();
			 Set<SkillDTO> skillListDto = new HashSet();
			 for(Skill skill: skillList) {
				 SkillDTO skillDto = new SkillDTO(skill.getId(), skill.getName());
				 skillListDto.add(skillDto);
			 }
			 empDto[count].setSkillList(skillListDto);
			 count++;
		 }
		 return empDto;
	 }
}
