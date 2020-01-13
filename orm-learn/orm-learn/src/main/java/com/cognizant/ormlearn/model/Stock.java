package com.cognizant.ormlearn.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {
	
	@Id
	@Column(name="st_id")
	int id;
	
	@Column(name="st_code")
	String code;
	
	@Column(name="st_date")
	Date date;
	
	@Column(name="st_open")
	BigDecimal open;
	
	@Column(name="st_close")
	BigDecimal close;
	
	@Column(name="st_volume")
	BigDecimal volume;

	@Override
	public String toString() {
		return "Stock [code=" + code + ", date=" + date + ", open=" + open + ", close=" + close + ", volume=" + volume
				+ "]\n";
	}
	
	
}
