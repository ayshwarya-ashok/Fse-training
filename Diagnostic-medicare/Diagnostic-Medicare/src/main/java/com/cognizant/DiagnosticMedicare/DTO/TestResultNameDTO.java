package com.cognizant.DiagnosticMedicare.DTO;

import com.cognizant.DiagnosticMedicare.model.Medicare;

public class TestResultNameDTO {
private int id;

	
	private int normalRange;

	private String testName;
	
//	@ManyToMany(mappedBy="testResultNamesList")
//	private Set<Medicare> medicareList;
	
	
	private Medicare medicare;

	public TestResultNameDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestResultNameDTO(int id, int normalRange, String testName, Medicare medicare) {
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
		return "TestResultNameDTO [id=" + id + ", normalRange=" + normalRange + ", testName=" + testName + ", medicare="
				+ medicare + "]";
	}
	
}
