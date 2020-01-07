package com.cognizant.medicaremanagement.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "request")
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "re_id")
	private int reqId;
	@Column(name = "re_customer_name")

	private String customerName;
//	
//	@Column(name = "re_pa_id")
//
//	private int customerId;
//	
//	@Column(name = "re_ms_id")
//
//	private int mediServiceId;

	@Column(name = "re_active")

	private int active;


	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Request(String customerName, int active) {
		super();
		//this.reqId = reqId;
		this.customerName = customerName;
		//this.customerId = customerId;
	//	this.mediServiceId = mediServiceId;
		this.active = active;
	}


//
//	public int getReqId() {
//		return reqId;
//	}
//
//	public void setReqId(int reqId) {
//		this.reqId = reqId;
//	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

//	public int getMediServiceId() {
//		return mediServiceId;
//	}
//
//	public void setMediServiceId(int mediServiceId) {
//		this.mediServiceId = mediServiceId;
//	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	
//	public int getCustomerId() {
//		return customerId;
//	}
//
//
//
//	public void setCustomerId(int customerId) {
//		this.customerId = customerId;
//	}
//


	@Override
	public String toString() {
		return "Request [customerName=" + customerName +  ", active=" + active + "]";
	}

	
}
