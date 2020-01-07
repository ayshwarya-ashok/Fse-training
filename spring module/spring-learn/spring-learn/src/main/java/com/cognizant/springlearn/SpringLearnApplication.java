package com.cognizant.springlearn;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public static void main(String[] args) {
		//displayEmployee();
		SpringApplication.run(SpringLearnApplication.class, args);
	}
//	public static void displayEmployee() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("BeansEbox.xml");
//		SimpleDateFormat format = (SimpleDateFormat) context.getBean("dateFormat");
//		try {
//			System.out.println(format.parse("22/06/1998"));
//		} catch (ParseException e) {
//			 LOGGER.error("invalid date");
//		}
//		//ApplicationContext context1= new ClassPathXmlApplicationContext("employee.xml");
//		//Employee employee = (Employee)context1.getBean("employee");
//		
//		 LOGGER.info("Start");
//		// LOGGER.debug(employee.toString());
//		 LOGGER.info("end");
//		//System.out.println(employee);
//	}
}
