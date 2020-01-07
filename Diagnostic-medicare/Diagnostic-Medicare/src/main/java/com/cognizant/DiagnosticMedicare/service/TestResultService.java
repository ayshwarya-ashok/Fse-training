package com.cognizant.DiagnosticMedicare.service;

import org.springframework.stereotype.Service;

import com.cognizant.DiagnosticMedicare.model.TestResult;

@Service
public interface TestResultService {
	public TestResult getTestResult(int requestId);
}
