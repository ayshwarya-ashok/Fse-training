package com.cognizant.DiagnosticMedicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.DiagnosticMedicare.model.TestResult;

public interface TestResultRepository extends JpaRepository<TestResult, Integer> {
	TestResult findById(int id);
	
	@Query(nativeQuery=true, value="select * from test_result where re_id = ?1")
	TestResult getTestResult(int requestId);

}
