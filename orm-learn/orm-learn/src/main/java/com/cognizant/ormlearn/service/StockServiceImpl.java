package com.cognizant.ormlearn.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.dao.StockRepository;
import com.cognizant.ormlearn.model.Stock;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	StockRepository stockRepository;

	@Override
	public List<Stock> filterByClose(String code, BigDecimal close) {
		
		return stockRepository.filterByClose(code, close);
	}

	@Override
	public List<Stock> filterByDate(int year, int month, String code) {
		
		return stockRepository.filterByDate(year, month, code);
	}

	@Override
	public List<Stock> top3ByVolume(Pageable pageable) {
		
		return stockRepository.top3ByVolume(pageable);
	}

	@Override
	public List<Stock> lowest3ByVolume(String code, Pageable pageable) {
		
		return stockRepository.lowest3ByVolume(code, pageable);
	}

	@Override
	public List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal close) {
		
		return stockRepository.findByCodeAndCloseGreaterThan(code, close);
	}

	@Override
	public List<Stock> findTop3ByOrderByVolumeDesc() {
		
		return stockRepository.findTop3ByOrderByVolumeDesc();
	}

	@Override
	public List<Stock> findTop3ByCodeOrderByCloseAsc(String code) {
		
		return stockRepository.findTop3ByCodeOrderByCloseAsc(code);
	}

	@Override
	public List<Stock> findByDateBetweenAndCode(Date startDate, Date endDate, String code) {
		
		return stockRepository.findByDateBetweenAndCode(startDate, endDate, code);
	}

}
