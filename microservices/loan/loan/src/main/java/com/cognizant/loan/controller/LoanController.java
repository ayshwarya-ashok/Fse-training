package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loan.model.Loan;


@RestController
@RequestMapping("/loans")
public class LoanController {

	@GetMapping("/{number}")
	public Loan getLoanDetails(@PathVariable String number) {
		return new Loan("H00987987972342", "car", 400000, 3258, 18);
		
	}
}
