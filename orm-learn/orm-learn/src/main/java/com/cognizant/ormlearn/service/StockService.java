package com.cognizant.ormlearn.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Stock;

@Service
public interface StockService {
	public List<Stock> filterByClose(String code, BigDecimal close);
	public List<Stock> filterByDate(int year, int month, String code);
	public List<Stock> top3ByVolume(Pageable pageable);
	public List<Stock> lowest3ByVolume(String code, Pageable pageable);
	public List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal close);
	public List<Stock> findTop3ByOrderByVolumeDesc();
	public List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
	public List<Stock> findByDateBetweenAndCode(Date startDate, Date endDate, String code);
}
