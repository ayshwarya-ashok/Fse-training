package com.cognizant.employee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employee.dao.SkillRepository;
import com.cognizant.employee.model.Skill;
@Service
public class SkillServiceImpl implements SkillService {
	@Autowired
	SkillRepository skillRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(SkillServiceImpl .class);

	
	@Override
	public Skill get(int id) {
		LOGGER.info("Start");
		return skillRepository.findById(id).get();
	}

	@Override
	public void save(Skill skill) {
		LOGGER.info("Start");
		skillRepository.save(skill);
		LOGGER.info("End");
	}

}
