package com.abc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentDemo {
	
	public static void main(String[] agrs) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
		StudentService studentService = (StudentService)factory.getBean("studentServiceImpl");
		studentService.add();
		studentService.delete();
		studentService.update();
		studentService.fetch();
	}
}
