package com.cognizant.DiagnosticMedicare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test_result_name")
public class TestResultName {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tn_id")
	private int id;

	@Column(name = "tn_normal_range")
	private int normalRange;

	@Column(name = "tn_test_name")
	private String testName;

//	@ManyToMany(mappedBy="testResultNamesList")
//	private Set<Medicare> medicareList;

	@ManyToOne
	@JoinColumn(name = "ms_id")

	private Medicare medicare;

	public TestResultName() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestResultName(int id, int normalRange, String testName, Medicare medicare) {
		super();
		this.id = id;
		this.normalRange = normalRange;
		this.testName = testName;
		this.medicare = medicare;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNormalRange() {
		return normalRange;
	}

	public void setNormalRange(int normalRange) {
		this.normalRange = normalRange;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Medicare getMedicare() {
		return medicare;
	}

	public void setMedicare(Medicare medicare) {
		this.medicare = medicare;
	}

	@Override
	public String toString() {
		return "TestResultName [id=" + id + ", normalRange=" + normalRange + ", testName=" + testName + "]";
	}
}
