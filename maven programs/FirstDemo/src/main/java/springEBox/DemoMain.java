package springEBox;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("BeansEbox.xml");
		SimpleDateFormat format = (SimpleDateFormat) context.getBean("dateFormat");
		try {
			System.out.println(format.parse("01/10/2019"));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		Country country = (Country)context.getBean("country");
		System.out.println(country);
		Country country1 = (Country)context.getBean("country");
		System.out.println(country1);
		/*
		 * System.out.println("Code   Name"); System.out.print(country.getCode()+"\t");
		 * System.out.print(country.getName());
		 */
		
	}

}
