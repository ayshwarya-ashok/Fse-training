package com.cognizant.employee.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employee.dto.DepartmentDTO;
import com.cognizant.employee.dto.EmployeeDTO;
import com.cognizant.employee.dto.SkillDTO;
import com.cognizant.employee.model.Employee;
import com.cognizant.employee.model.Skill;
import com.cognizant.employee.service.EmployeeService;



@RestController
@RequestMapping("/")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

//	@GetMapping("employee")
//	public List<Employee> getAllEmployee() {
//		return employeeService.getAllEmployees();
//	}
	@GetMapping("/employee")
	public EmployeeDTO[] getAllEmployees() {
		// return employeeService.getAllEmployees();
		return transformEmployeeToDTO(employeeService.getAllEmployees());
	}

	private EmployeeDTO[] transformEmployeeToDTO(List<Employee> employee) {
		EmployeeDTO[] empDto = new EmployeeDTO[employee.size()];
		int count = 0;
		for (Employee emp : employee) {
			empDto[count] = new EmployeeDTO();
			empDto[count].setId(emp.getId());
			empDto[count].setName(emp.getName());
			empDto[count].setDateOfBirth(emp.getDateOfBirth());
			empDto[count].setSalary(emp.getSalary());
			empDto[count].setPermanent(emp.isPermanent());
			DepartmentDTO deptDto = new DepartmentDTO(emp.getDepartment().getId(), emp.getDepartment().getName());
			empDto[count].setDepartment(deptDto);
			Set<Skill> skillSet = emp.getSkillList();
			Set<SkillDTO> skillDto = new HashSet();
			for (Skill skill : skillSet) {
				SkillDTO sk = new SkillDTO();
				sk.setId(skill.getId());
				sk.setName(skill.getName());
				skillDto.add(sk);
			}
			empDto[count].setSkillList(skillDto);
			count++;
		}
		return empDto;

	}

}
