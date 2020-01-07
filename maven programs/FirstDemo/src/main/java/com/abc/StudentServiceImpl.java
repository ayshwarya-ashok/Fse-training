package com.abc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentDao studentDao;
	
	@Override
	public void add() {
		studentDao.add();
		
	}

	@Override
	public void delete() {
		studentDao.delete();
		
	}

	@Override
	public void update() {
		studentDao.update();
		
	}

	@Override
	public void fetch() {
		studentDao.fetch();
		
	}
	
}
