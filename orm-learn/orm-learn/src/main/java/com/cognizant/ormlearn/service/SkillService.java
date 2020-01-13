package com.cognizant.ormlearn.service;

import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Skill;

@Service
public interface SkillService {
	Skill get(int id);
}
