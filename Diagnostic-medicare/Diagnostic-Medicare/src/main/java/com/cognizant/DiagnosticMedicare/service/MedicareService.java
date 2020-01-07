package com.cognizant.DiagnosticMedicare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.DiagnosticMedicare.model.Medicare;

@Service
public interface MedicareService {

	public List<Medicare> getMedicareList();

	public Medicare getOneMedicare(int medicareId);

	public boolean editMedicareService(Medicare medicare);
}
