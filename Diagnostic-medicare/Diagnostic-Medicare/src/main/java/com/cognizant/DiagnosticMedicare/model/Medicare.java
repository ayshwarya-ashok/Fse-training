package com.cognizant.DiagnosticMedicare.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "medicare_services")
public class Medicare {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ms_id")
	private int id;

	@Column(name = "ms_medicare_service")

	private String medicareService;

	@Column(name = "ms_service_description")

	private String serviceDescription;

	@Column(name = "ms_amount")

	private int amount;

	@Column(name = "ms_agent_commission")

	private int agentCommission;

	@ManyToMany(mappedBy = "medicareList")
	private Set<Doctor> doctor;

	@OneToMany(mappedBy = "medicare")
	@JsonIgnoreProperties("medicare")
	private Set<TestResultName> testResultName;

	@OneToMany
	@JoinColumn(name = "re_id")
	private Set<Request> allRequests;

	public Medicare() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medicare(int id, String medicareService, String serviceDescription, int amount, int agentCommission,
			Set<Doctor> doctor, Set<TestResultName> testResultName, Set<Request> allRequests) {
		super();
		this.id = id;
		this.medicareService = medicareService;
		this.serviceDescription = serviceDescription;
		this.amount = amount;
		this.agentCommission = agentCommission;
		this.doctor = doctor;
		this.testResultName = testResultName;
		this.allRequests = allRequests;
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

	public Set<Doctor> getDoctor() {
		return doctor;
	}

	public void setDoctor(Set<Doctor> doctor) {
		this.doctor = doctor;
	}

	public Set<TestResultName> getTestResultName() {
		return testResultName;
	}

	public void setTestResultName(Set<TestResultName> testResultName) {
		this.testResultName = testResultName;
	}

	public Set<Request> getAllRequests() {
		return allRequests;
	}

	public void setAllRequests(Set<Request> allRequests) {
		this.allRequests = allRequests;
	}

	@Override
	public String toString() {
		return "Medicare [id=" + id + ", medicareService=" + medicareService + ", serviceDescription="
				+ serviceDescription + ", amount=" + amount + ", agentCommission=" + agentCommission + ", doctor="
				+ doctor + ", testResultName=" + testResultName + ", allRequests=" + allRequests + "]";
	}

}
