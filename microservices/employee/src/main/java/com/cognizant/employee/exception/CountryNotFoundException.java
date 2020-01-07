package com.cognizant.employee.exception;

public class CountryNotFoundException extends Exception {
	
	String message;

	public CountryNotFoundException(String message) {
		super();
		this.message = message;
	}

}
