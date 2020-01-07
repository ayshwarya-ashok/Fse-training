package com.abc;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class HelloWorld {
	private String message;
	private List<String> citiesList;
	private Set<String> fruitsSet;
	private Map<Integer, String> foodMap;
	
	public Map<Integer, String> getFoodMap() {
		return foodMap;
	}
	public void setFoodMap(Map<Integer, String> foodMap) {
		this.foodMap = foodMap;
	}
	public Set<String> getFruitsSet() {
		return fruitsSet;
	}
	public void setFruitsSet(Set<String> fruitsSet) {
		this.fruitsSet = fruitsSet;
	}

	private String wish;
	private int number;
	
	HelloWorld(String wish){
		this.wish=wish;
	}
	HelloWorld(String wish, String message){
		//System.out.println("string, string is called");
		this.wish = wish;
		this.message = message;
	}
	HelloWorld(String wish, int number){
		//System.out.println("string, number is called");
		this.wish = wish;
		this.number = number;
	}
	HelloWorld(int number, String wish){
		//System.out.println("number, string is called");
		this.wish = wish;
		this.number = number;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void greet() {
		System.out.println(wish+number+"!");
		//System.out.println("constructor injection"+wish+message);
	}

	public List<String> getCitiesList() {
		System.out.println("Cities through list");
		return citiesList;
	}

	public void setCitiesList(List<String> cities) {
		
		this.citiesList = cities;
	}
	
}
