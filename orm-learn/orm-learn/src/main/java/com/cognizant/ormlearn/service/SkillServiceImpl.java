package com.cognizant.ormlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.dao.SkillRepository;
import com.cognizant.ormlearn.model.Skill;

@Service
public class SkillServiceImpl implements SkillService{
	
	@Autowired
	SkillRepository skillRepository;
	@Override
	public Skill get(int id) {
	
		return skillRepository.findById(id).get();
	}

}
