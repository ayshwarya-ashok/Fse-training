package com.cognizant.springWar.exception;

public class StudentNotFoundException extends Exception {
	String mssg;

	public StudentNotFoundException(String mssg) {
		super();
		this.mssg = mssg;
	}
	public String getMssg() {
		return this.mssg;
	}
}
