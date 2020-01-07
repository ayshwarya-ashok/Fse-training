package com.cognizant.authenticationservice.exception;

public class UserAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	String userExistsMssg;

	public UserAlreadyExistsException(String userExistsMssg) {
		super();
		this.userExistsMssg = userExistsMssg;
	}

	public String getUserExistsMssg() {

		return userExistsMssg;
	}

}
