package com.cognizant.menuitemservice.model;

import java.util.Date;

public class MyError {
	String mssg;
	Date date;
	String description;

	public MyError(String mssg, Date date, String description) {
		super();
		this.mssg = mssg;
		this.date = date;
		this.description = description;
	}

	public String getMssg() {
		return mssg;
	}

	public void setMssg(String mssg) {
		this.mssg = mssg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
