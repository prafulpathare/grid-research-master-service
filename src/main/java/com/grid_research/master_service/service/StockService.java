package com.grid_research.master_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grid_research.master_service.entity.Stock;
import com.grid_research.master_service.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepository;

	public List<Stock> getStocks() {
		return stockRepository.findAll();
	}

	public Stock getStockByTicker(String ticker) {
		return stockRepository.findByTicker(ticker).orElse(null);
	}

}
