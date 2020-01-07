package com.cognizant.springlearn.country.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.country.model.Country;
//import com.cognizant.springlearn.country.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService{

	@Override
	public List<Country> getAllCountries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Country> getCountry(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Country> getCountryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country addCountry(Country country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country updateCountry(Country country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCountry(String code) {
		// TODO Auto-generated method stub
		
	}

//	@Autowired
//	CountryRepository countryRepository;
//	
//	@Override
//	public List<Country> getAllCountries() {
//		
//		return countryRepository.findAll();
//	}
//
//	@Override
//	public Optional<Country> getCountry(String code) {
//		
//		return countryRepository.findById(code);
//	}
//
//	@Override
//	public Country addCountry(Country country) {
//		
//		return countryRepository.save(country);
//	}
//
//	@Override
//	public Country updateCountry(Country country) {
//
//		return countryRepository.save(country);
//	}
//
//	@Override
//	public void deleteCountry(String code) {
//		countryRepository.deleteById(code);
//		
//	}
//
//	@Override
//	public List<Country> getCountryByName(String name) {
//		
//		return countryRepository.findByName(name);
//	}

}
