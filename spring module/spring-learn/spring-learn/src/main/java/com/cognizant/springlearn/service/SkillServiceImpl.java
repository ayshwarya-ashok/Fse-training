package com.cognizant.springlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Skill;
import com.cognizant.springlearn.repository.SkillRepository;


@Service
public class SkillServiceImpl implements SkillService{
	
	@Autowired
	SkillRepository skillRepository;
	@Override
	public Skill get(int id) {
	
		return skillRepository.findById(id).get();
	}

}
