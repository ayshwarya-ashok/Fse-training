package com.cognizant.medicaremanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.medicaremanagement.model.Medicare;
import com.cognizant.medicaremanagement.model.Request;
import com.cognizant.medicaremanagement.service.MedicareService;
import com.cognizant.medicaremanagement.service.RequestService;


@RestController
@RequestMapping("doctor")
public class DoctorController {
	
	@Autowired
	RequestService requestService;
	@Autowired
	MedicareService medicareService;

	@GetMapping("/doctorViewRequest")
	public List<Request> doctorRequest(){
		return requestService.doctorRequest();	
	}
	
	@GetMapping("/medicareServiceList")
	public List<Medicare> getMedicareList(){
		return medicareService.getMedicareList();
	}

}
