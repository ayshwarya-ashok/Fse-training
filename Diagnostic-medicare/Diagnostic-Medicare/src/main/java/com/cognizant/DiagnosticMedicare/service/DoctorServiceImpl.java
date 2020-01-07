package com.cognizant.DiagnosticMedicare.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.DiagnosticMedicare.model.Doctor;
import com.cognizant.DiagnosticMedicare.model.Medicare;
import com.cognizant.DiagnosticMedicare.model.TestResult;
import com.cognizant.DiagnosticMedicare.repository.DoctorRepository;
import com.cognizant.DiagnosticMedicare.repository.MedicareRepository;
import com.cognizant.DiagnosticMedicare.repository.RequestRepository;
import com.cognizant.DiagnosticMedicare.repository.TestResultRepository;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	TestResultRepository testResultRepository;
	
	@Autowired
	MedicareRepository medicareRepository;
	
	@Autowired
	RequestRepository requestRepository;

	@Override
	public boolean addMedicareService(String userName, int medicareServiceId) {
		
		Doctor doctor = doctorRepository.findByUserName(userName);
		Set<Medicare> medicareList = new HashSet<Medicare>();
		medicareList = doctor.getMedicareList();
		Medicare oneMedicare = medicareRepository.findById(medicareServiceId).get();
		
		if(medicareList.size() == 0) {
			medicareList.add(oneMedicare);
			doctor.setMedicareList(medicareList);;
			doctorRepository.save(doctor);
			return true;
		}else {
			int flag = 0;
			for(Medicare itr : medicareList) {
				if(itr.getId() == medicareServiceId) {
					flag = 1;
					break;
				}
			}
			if(flag == 0) {
				medicareList.add(oneMedicare);
				doctor.setMedicareList(medicareList);;
				doctorRepository.save(doctor);
				return true;
			}else {
				return false;
			}
				
		}
	}

	
	@Override
	public boolean updateTestResult(TestResult testResult) {
		testResultRepository.save(testResult);
		return true;
	}


}
