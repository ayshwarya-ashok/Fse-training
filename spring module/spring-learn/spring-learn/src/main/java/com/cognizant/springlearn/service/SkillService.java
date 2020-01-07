package com.cognizant.springlearn.service;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Skill;

@Service
public interface SkillService {
	Skill get(int id);
}

