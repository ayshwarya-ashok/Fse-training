package com.cognizant.DiagnosticMedicare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test_result")
public class TestResult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tr_id")
	private int id;

	@Column(name = "tr_pa_username")
	private String patientName;

	@Column(name = "tr_do_username")
	private String doctorName;

	@Column(name = "tr_ms_name")
	private String mediserviceName;

	@Column(name = "tr_ms_amount")
	private int mediserviceAmount;

	@Column(name = "tr_ag_commission")
	private int agentCommission;

	@Column(name = "tr_test_name_1")
	private String testName1;

	@Column(name = "tr_normal_range_1")
	private int normalRange1;

	@Column(name = "tr_actual_range_1")
	private int actualRange1;

	@Column(name = "tr_test_name_2")
	private String testName2;

	@Column(name = "tr_normal_range_2")
	private int normalRange2;

	@Column(name = "tr_actual_range_2")
	private int actualRange2;

	@OneToOne
	@JoinColumn(name = "re_id")
	private Request request;

	public TestResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestResult(int id, String patientName, String doctorName, String mediserviceName, int mediserviceAmount,
			int agentCommission, String testName1, int normalRange1, int actualRange1, String testName2,
			int normalRange2, int actualRange2) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.mediserviceName = mediserviceName;
		this.mediserviceAmount = mediserviceAmount;
		this.agentCommission = agentCommission;
		this.testName1 = testName1;
		this.normalRange1 = normalRange1;
		this.actualRange1 = actualRange1;
		this.testName2 = testName2;
		this.normalRange2 = normalRange2;
		this.actualRange2 = actualRange2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getMediserviceName() {
		return mediserviceName;
	}

	public void setMediserviceName(String mediserviceName) {
		this.mediserviceName = mediserviceName;
	}

	public int getMediserviceAmount() {
		return mediserviceAmount;
	}

	public void setMediserviceAmount(int mediserviceAmount) {
		this.mediserviceAmount = mediserviceAmount;
	}

	public int getAgentCommission() {
		return agentCommission;
	}

	public void setAgentCommission(int agentCommission) {
		this.agentCommission = agentCommission;
	}

	public String getTestName1() {
		return testName1;
	}

	public void setTestName1(String testName1) {
		this.testName1 = testName1;
	}

	public int getNormalRange1() {
		return normalRange1;
	}

	public void setNormalRange1(int normalRange1) {
		this.normalRange1 = normalRange1;
	}

	public int getActualRange1() {
		return actualRange1;
	}

	public void setActualRange1(int actualRange1) {
		this.actualRange1 = actualRange1;
	}

	public String getTestName2() {
		return testName2;
	}

	public void setTestName2(String testName2) {
		this.testName2 = testName2;
	}

	public int getNormalRange2() {
		return normalRange2;
	}

	public void setNormalRange2(int normalRange2) {
		this.normalRange2 = normalRange2;
	}

	public int getActualRange2() {
		return actualRange2;
	}

	public void setActualRange2(int actualRange2) {
		this.actualRange2 = actualRange2;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "TestResult [id=" + id + ", patientName=" + patientName + ", doctorName=" + doctorName
				+ ", mediserviceName=" + mediserviceName + ", mediserviceAmount=" + mediserviceAmount
				+ ", agentCommission=" + agentCommission + ", testName1=" + testName1 + ", normalRange1=" + normalRange1
				+ ", actualRange1=" + actualRange1 + ", testName2=" + testName2 + ", normalRange2=" + normalRange2
				+ ", actualRange2=" + actualRange2 + "]";
	}
}
