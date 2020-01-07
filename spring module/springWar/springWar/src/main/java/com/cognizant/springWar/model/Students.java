package com.cognizant.springWar.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Students {
	private int id;
	@NotNull
	@Size(min=2, max=30, message="Length shold be min of 2 and max of 30 characters")
	private String sname;
	@NotNull
	@Min(value=0, message="Minimum mark is 0")
	@Max(value=100, message="Maximum mark is 100")
	private int marks;
	
	public Students() {
		
	}
	public Students(int id, String name, int marks) {
		this.id = id;
		this.sname = name;
		this.marks = marks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", sname=" + sname + ", marks=" + marks + "]";
	}
	
}
