package com.gridresearch.masterservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gridresearch.masterservice.entity.Company;
import com.gridresearch.masterservice.entity.Promotor;
import com.gridresearch.masterservice.entity.Stock;
import com.gridresearch.masterservice.service.StockService;

@RestController
@RequestMapping(path = "/stock")
public class StockController {

	@Autowired
	private StockService stockService;

	@GetMapping
	public ResponseEntity<List<Stock>> getStocks() {

		var stocks = stockService.getStocks();

		return stocks == null || stocks.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(stocks);
	}
	
	@GetMapping(path = "/{ticker}")
	public ResponseEntity<Stock> getStockByTicker(@PathVariable String ticker) {

		var stock = stockService.getStockByTicker(ticker);

		return stock == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(stock);
	}
	
	@GetMapping(path = "/{ticker}/promotors")
	public ResponseEntity<List<Promotor>> getStocPromotorskByTicker(@PathVariable String ticker) {

		var promotors = stockService.getStocPromotorskByTicker(ticker);

		return promotors == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(promotors);
	}
	
	@GetMapping(path = "/{ticker}/company")
	public ResponseEntity<Company> getStockCompanyByTicker(@PathVariable String ticker) {

		var company = stockService.getStockCompanyByTicker(ticker);

		return company == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(company);
	}

}
