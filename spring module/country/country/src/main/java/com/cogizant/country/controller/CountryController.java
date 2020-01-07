package com.cogizant.country.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cogizant.country.dao.CountryDao;
import com.cogizant.country.model.Country;

@RestController
@RequestMapping("/")
public class CountryController {
	@Autowired
	CountryDao countryDao;
	@GetMapping("/country")
	public Country getCountry() {
		return countryDao.getCountry();
	}

}
