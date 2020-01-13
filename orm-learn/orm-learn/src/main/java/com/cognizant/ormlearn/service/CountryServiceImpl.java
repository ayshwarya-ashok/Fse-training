package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.dao.CountryRepository;
import com.cognizant.ormlearn.model.Country;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	CountryRepository countryRepository;
	
	@Override
	public List<Country> getAllCountries() {
		
		return countryRepository.findAll();
	}

	@Override
	public Optional<Country> getCountry(String code) {
		
		return countryRepository.findById(code);
	}

	@Override
	public Country addCountry(Country country) {
		
		return countryRepository.save(country);
	}

	@Override
	public Country updateCountry(Country country) {

		return countryRepository.save(country);
	}

	@Override
	public void deleteCountry(Country country) {
		countryRepository.delete(country);
		
	}

	@Override
	public List<Country> getCountryByName(String name) {
		
		return countryRepository.findByName(name);
	}

}
