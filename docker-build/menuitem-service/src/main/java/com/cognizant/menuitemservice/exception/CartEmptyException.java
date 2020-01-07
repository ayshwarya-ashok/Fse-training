package com.cognizant.menuitemservice.exception;

public class CartEmptyException extends Exception {

	private static final long serialVersionUID = 1L;
	String cartEmptyMssg;

	public CartEmptyException(String mssg) {
		super();
		this.cartEmptyMssg = mssg;
	}

	public String getCartEmptyMssg() {

		return this.cartEmptyMssg;
	}

}
