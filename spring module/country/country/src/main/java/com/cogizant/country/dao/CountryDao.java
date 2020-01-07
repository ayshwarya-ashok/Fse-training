package com.cogizant.country.dao;

import org.springframework.stereotype.Repository;

import com.cogizant.country.model.Country;

@Repository
public interface CountryDao {
	public Country getCountry();
		
	

}
