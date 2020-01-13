package com.cognizant.ormlearn;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;

import com.cognizant.ormlearn.dao.StockRepository;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;
	private static StockService stockService;
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;
	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		// countryService = context.getBean(CountryService.class);
		// stockService = context.getBean(StockService.class);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		// testGetAllCountries();
		// testGetCountry();
		// testAddCountry();
		// testGetAllCountries();
		// testUpdateCountry();
		// testDeleteCountry();
		// testGetAllCountries();
		// testGetCountryByName();
		// testFilterByClose();
		// testFilterByDate();
		// testTop3ByVolume();
		// testLowest3ByVolume();
		// testFindByCodeAndCloseGreaterThan();
		// testFindTopByOrderByVolumeDesc();
		// testFindTop3ByCodeOrderByCloseAsc();
		// testFindByDateBetweenAndByCode();
		// testGetEmployee();
		// testAddEmployee();
		// testUpdateEmployee();
		// testGetDepartment();
		//testAddSkillToEmployee();	
		testGetAllPermanentEmployees();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	private static void testGetCountry() {
		LOGGER.info("Start");
		Optional<Country> country = countryService.getCountry("IN");
		LOGGER.debug("country={}", country);
		LOGGER.info("End");
	}

	private static void testAddCountry() {
		LOGGER.info("Start");
		Country country = new Country("US", "United States of America");
		Country countries = countryService.addCountry(country);
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	private static void testUpdateCountry() {
		LOGGER.info("Start");
		Country country = new Country("US", "United Kingdom");
		Country updatedCountry = countryService.updateCountry(country);
		LOGGER.debug("countries={}", updatedCountry);
		LOGGER.info("End");
	}

	private static void testDeleteCountry() {
		LOGGER.info("Start");
		Country country = new Country("IN", "India");
		countryService.deleteCountry(country);
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	private static void testGetCountryByName() {
		LOGGER.info("Start");
		List<Country> country = countryService.getCountryByName("India");
		LOGGER.debug("country={}", country);
		LOGGER.info("End");
	}

	private static void testFilterByClose() {
		List<Stock> stocks = stockService.filterByClose("GOOGL", new BigDecimal(1250));
		LOGGER.debug("Stocks={}", stocks);
	}

	private static void testFilterByDate() {
		List<Stock> stocks = stockService.filterByDate(2019, 9, "FB");
		LOGGER.debug("Stocks={}", stocks);
	}

	private static void testTop3ByVolume() {
		List<Stock> stocks = stockService.top3ByVolume(PageRequest.of(0, 3));
		LOGGER.debug("Stocks={}", stocks);
	}

	private static void testLowest3ByVolume() {
		List<Stock> stocks = stockService.lowest3ByVolume("NFLX", PageRequest.of(0, 3));
		LOGGER.debug("Stocks={}", stocks);
	}

	private static void testFindByCodeAndCloseGreaterThan() {
		List<Stock> stocks = stockService.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal(1250));
		LOGGER.debug("Stocks={}", stocks);
	}

	private static void testFindTopByOrderByVolumeDesc() {
		List<Stock> stocks = stockService.findTop3ByOrderByVolumeDesc();
		LOGGER.debug("Stocks={}", stocks);
	}

	private static void testFindTop3ByCodeOrderByCloseAsc() {
		List<Stock> stocks = stockService.findTop3ByCodeOrderByCloseAsc("NFLX");
		LOGGER.debug("Stocks={}", stocks);
	}

	private static void testFindByDateBetweenAndByCode() {
		List<Stock> stocks = stockService.findByDateBetweenAndCode(new Date(119, 9, 1), new Date(119, 9, 31), "FB");
		LOGGER.debug("Stocks={}", stocks);
	}

	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");
	}

//	private static void testAddEmployee(Employee employee) {
//		Department department = departmentService.get(1);
//		//Employee employee = new Employee(0, "Smith", 50000, true, new Date(1998, 04, 23), department);
//		employeeService.save(employee);
//		LOGGER.debug("Department:{}", employee.getDepartment());
//		LOGGER.debug("Employee:{}", employee);
//	}
	private static void testAddEmployee() {
		Department department = departmentService.get(1);
		Set<Skill> skillList = testAddSkillToEmployee();
		Employee employee = new Employee(0, "Ayshu", 50000, true, new Date(1998, 02, 26), department, skillList);
		employeeService.save(employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Employee:{}", employee);
	}

	private static void testUpdateEmployee() {
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		Department department = departmentService.get(1);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
	}
	 private static void testGetDepartment() {
		 Department department = departmentService.get(3);
		 LOGGER.debug("EmployeeList:{}", department.getEmployeeList());
	 }
//	 private static void testAddSkillToEmployee() {
//		 Employee employee = employeeService.get(3);
//		 Skill skill = skillService.get(2);
//		 Set<Skill> skillList = employee.getSkillList();
//		 skillList.add(skill);
//		 testAddEmployee(employee);
//	 }
	 private static Set<Skill> testAddSkillToEmployee() {
		 //Employee employee = employeeService.get(3);
		 Skill skill1 = skillService.get(1);
		 Skill skill2 = skillService.get(2);
		 //Set<Skill> skillList = employee.getSkillList();
		 Set<Skill> skillList = new HashSet();
		 skillList.add(skill1);
		 skillList.add(skill2);
		 return skillList;
	 }
	 private static void testGetAllPermanentEmployees() {
	        LOGGER.info("Start");
	        List<Employee> employees = employeeService.getAllPermanentEmployees();
	        LOGGER.debug("Permanent Employees:{}", employees);
	        employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
	        LOGGER.info("End");
	    }
}
