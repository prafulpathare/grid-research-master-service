package com.gridresearch.masterservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grid_research.master_service.entity.Stock;
import com.grid_research.master_service.service.StockService;

@RestController
@RequestMapping(path = "/stock")
public class StockController {

	@Autowired
	private StockService stockService;

	@GetMapping
	public ResponseEntity<List<Stock>> getStocks() {

		var stocks = stockService.getStocks();

		return stocks == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(stocks);
	}
	
	@GetMapping(path = "/{ticker}")
	public ResponseEntity<Stock> getStockByTicker(@PathVariable String ticker) {

		var stock = stockService.getStockByTicker(ticker);

		return stock == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(stock);
	}

}
