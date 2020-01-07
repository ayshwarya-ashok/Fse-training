package com.cognizant.DiagnosticMedicare.DTO;

import java.util.Set;

import com.cognizant.DiagnosticMedicare.model.Doctor;

public class MedicareDTO {


	private int id;
	
	private String medicareService;

	private String serviceDescription;

	private int amount;
	
	private int agentCommission;
	
	private Set<DoctorDTO> doctor;
	
	private Set<TestResultNameDTO> testResultName;

	public MedicareDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public MedicareDTO(int id, String medicareService, String serviceDescription, int amount, int agentCommission,
			Set<DoctorDTO> doctor, Set<TestResultNameDTO> testResultName) {
		super();
		this.id = id;
		this.medicareService = medicareService;
		this.serviceDescription = serviceDescription;
		this.amount = amount;
		this.agentCommission = agentCommission;
		this.doctor = doctor;
		this.testResultName = testResultName;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedicareService() {
		return medicareService;
	}

	public void setMedicareService(String medicareService) {
		this.medicareService = medicareService;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAgentCommission() {
		return agentCommission;
	}

	public void setAgentCommission(int agentCommission) {
		this.agentCommission = agentCommission;
	}

	public Set<DoctorDTO> getDoctor() {
		return doctor;
	}

	public void setDoctor(Set<DoctorDTO> doctor) {
		this.doctor = doctor;
	}

	public Set<TestResultNameDTO> getTestResultName() {
		return testResultName;
	}



	public void setTestResultName(Set<TestResultNameDTO> testResultName) {
		this.testResultName = testResultName;
	}



	@Override
	public String toString() {
		return "MedicareDTO [id=" + id + ", medicareService=" + medicareService + ", serviceDescription="
				+ serviceDescription + ", amount=" + amount + ", agentCommission=" + agentCommission + ", doctor="
				+ doctor + ", testResultName=" + testResultName + "]";
	}
	
	
}
