package com.cognizant.ormlearn.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

	 @Query("select stock from Stock stock where stock.code = ?1")
	 Stock findByCode(String code);
	 
	 @Query("select stock from Stock stock where stock.code=?1 and stock.close>?2")
	 List<Stock> filterByClose(String code, BigDecimal close);
	 
	 @Query("select stock from Stock stock where (year(stock.date)=?1 and month(stock.date)=?2) and (stock.code=?3)")
	 List<Stock> filterByDate(int year, int month, String code);
	 
	 @Query("select stock from Stock stock order by stock.volume desc")
	 List<Stock> top3ByVolume(Pageable pageable);
	 
	 @Query("select stock from Stock stock where stock.code=?1 order by stock.close asc")
	 List<Stock> lowest3ByVolume(String code, Pageable pageable);
	 
	 List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal close);
	 
	 List<Stock> findTop3ByOrderByVolumeDesc();
	 
	 List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
	 
	 List<Stock> findByDateBetweenAndCode(Date startDate, Date endDate, String code);
}
