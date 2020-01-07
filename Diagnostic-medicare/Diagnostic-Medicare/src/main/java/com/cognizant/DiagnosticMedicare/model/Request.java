package com.cognizant.DiagnosticMedicare.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "request")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "re_id")
	private int reqId;

	@ManyToOne
	@JoinColumn(name = "pa_id")
	@JsonIgnoreProperties("allRequests")
	private Patient patient;

	@ManyToOne
	@JoinColumn(name = "ms_id")
	@JsonIgnoreProperties({ "allRequests", "doctor" })
	private Medicare medicareService;

	@ManyToOne
	@JoinColumn(name = "do_id")
	@JsonIgnoreProperties("medicareList")
	private Doctor doctor;

////	@OneToOne()
////	@JoinColumn(name="tr_id")
////	//@JsonIgnoreProperties(value= {"request"}, allowSetters = true) 
////	private TestResult testResult;
//
//	public TestResult getTestResult() {
//		return testResult;
//	}
//
//
//	public void setTestResult(TestResult testResult) {
//		this.testResult = testResult;
//	}

	@Column(name = "re_active")
	private String active;

	@Column(name = "re_date")
	private Date date;

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(int reqId, Patient patient, Medicare medicareService, Doctor doctor, String active, Date date) {
		super();
		this.reqId = reqId;
		this.patient = patient;
		this.medicareService = medicareService;
		this.doctor = doctor;
		this.active = active;
		this.date = date;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medicare getMedicareService() {
		return medicareService;
	}

	public void setMedicareService(Medicare medicareService) {
		this.medicareService = medicareService;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Request [reqId=" + reqId + ", patient=" + patient + ", medicareService=" + medicareService + ", doctor="
				+ doctor + ", active=" + active + ", date=" + date + "]";
	}
}
