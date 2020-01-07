package com.cognizant.employee.service;

import com.cognizant.employee.model.Skill;

public interface SkillService {
	
	Skill get(int id);

	void save(Skill skill);

}
