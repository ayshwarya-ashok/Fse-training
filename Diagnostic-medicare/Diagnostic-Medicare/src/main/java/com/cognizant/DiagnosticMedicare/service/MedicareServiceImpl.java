package com.cognizant.DiagnosticMedicare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.DiagnosticMedicare.model.Medicare;
import com.cognizant.DiagnosticMedicare.repository.MedicareRepository;
import com.cognizant.DiagnosticMedicare.repository.UserRepository;

@Service
public class MedicareServiceImpl implements MedicareService {

	@Autowired
	private MedicareRepository medicareRepository;
	
	@Override
	public List<Medicare> getMedicareList() {
		// TODO Auto-generated method stub
		return medicareRepository.findAll();
	}

	@Override
	public Medicare getOneMedicare(int medicareId) {
		return medicareRepository.findById(medicareId).get();
	}

	@Override
	public boolean editMedicareService(Medicare medicare) {
		medicareRepository.save(medicare);
		return true;
	}

}
