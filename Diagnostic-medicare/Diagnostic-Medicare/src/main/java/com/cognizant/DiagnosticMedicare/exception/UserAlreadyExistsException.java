package com.cognizant.DiagnosticMedicare.exception;


public class UserAlreadyExistsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException() {

	}

	public String getMessage() {
		return ("User already exists");
	}
}
