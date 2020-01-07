package com.cognizant.medicaremanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.medicaremanagement.model.Medicare;

@Service
public interface MedicareService {

	public List<Medicare> getMedicareList();
}
