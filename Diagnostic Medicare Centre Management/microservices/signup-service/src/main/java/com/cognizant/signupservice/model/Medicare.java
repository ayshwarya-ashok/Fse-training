package com.cognizant.signupservice.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
	
	
	public Medicare() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medicare(int id, String medicareService, String serviceDescription, int amount) {
		super();
		this.id = id;
		this.medicareService = medicareService;
		this.serviceDescription = serviceDescription;
		this.amount = amount;
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

	@Override
	public String toString() {
		return "Medicare [id=" + id + ", medicareService=" + medicareService + ", serviceDescription="
				+ serviceDescription + ", amount=" + amount + "]";
	}
	
	
}
	