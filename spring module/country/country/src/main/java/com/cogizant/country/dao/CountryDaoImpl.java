package com.cogizant.country.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cogizant.country.model.Country;
@Repository
public class CountryDaoImpl implements CountryDao{

	ApplicationContext context = new ClassPathXmlApplicationContext("counrty.xml");
	Country country = (Country) context.getBean("country");
	@Override
	public Country getCountry() {
		
		return country;
	}

}
