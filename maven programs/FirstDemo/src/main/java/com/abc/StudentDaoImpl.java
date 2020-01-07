package com.abc;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Override
	public void add() {
		System.out.println("Student added");
		
	}

	@Override
	public void delete() {
		System.out.println("Student deleted");
		
	}

	@Override
	public void update() {
		System.out.println("Student updated");
	}

	@Override
	public void fetch() {
		System.out.println("Student fetched");
		
	}

}
