package com.cognizant.medicaremanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.medicaremanagement.model.Medicare;
import com.cognizant.medicaremanagement.repository.MedicareRepository;


@Service
public class MedicareServiceImpl implements MedicareService {

	@Autowired
	private MedicareRepository medicareRepository;
	
	@Override
	public List<Medicare> getMedicareList() {
		return medicareRepository.findAll();
	}

}
