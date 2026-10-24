package com.gridresearch.masterservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gridresearch.masterservice.entity.Company;
import com.gridresearch.masterservice.entity.Promotor;
import com.gridresearch.masterservice.entity.Stock;
import com.gridresearch.masterservice.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;

	@Transactional(readOnly = true)
	public List<Stock> getStocks() {
		return stockRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Stock getStockByTicker(String ticker) {
		return stockRepository.findByTicker(ticker).orElse(null);
	}

	public Company getStockCompanyByTicker(String ticker) {
		var stock = getStockByTicker(ticker);
		if(stock == null) return null;
		
		return stock.getCompany();
	}

	public List<Promotor> getStocPromotorskByTicker(String ticker) {
		var stock = getStockByTicker(ticker);
		if(stock == null) return null;
		
		return stock.getPromotors();
	}
}
