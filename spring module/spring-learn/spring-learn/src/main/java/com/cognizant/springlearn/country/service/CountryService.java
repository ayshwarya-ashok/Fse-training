package com.cognizant.springlearn.country.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.country.model.Country;

@Service
public interface CountryService {
	
	public List<Country> getAllCountries();
	public Optional<Country> getCountry(String code);
	public List<Country> getCountryByName(String name);
	public Country addCountry(Country country);
	public Country updateCountry(Country country);
	public void deleteCountry(String code);
}