package com.cognizant.springlearn.country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cognizant.springlearn.country.model.Country;
import com.cognizant.springlearn.country.service.CountryService;

@RestController
@RequestMapping("/")
public class CountryController {

	@Autowired
	CountryService countryService;
	@GetMapping("/country")
	public List<Country> getCountry() {
		return countryService.getAllCountries();
	}
	@PostMapping("/country")
	public void addCountry(@RequestBody Country country) {
		countryService.addCountry(country);
	}
	@PutMapping("/country")
	public void updateCountry(@RequestBody Country country) {
		countryService.updateCountry(country);
	}
	@DeleteMapping("/country/{code}")
	public void deleteCountry(@PathVariable String code) {
		countryService.deleteCountry(code);
	}
}
