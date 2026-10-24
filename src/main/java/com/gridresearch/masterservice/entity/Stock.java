package com.grid_research.master_service.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name =  "stock")
public class Stock {
	
	@Id
	private Long id;
	
	@Column(name = "ticker")
	private String ticker;

	@Column(name = "price")
	private Float price;
	
	@Column(name = "market_cap")
	private Float marketCap;
	
	@Column(name = "pb")
	private Float priceToBook;
	
	@Column(name = "pe")
	private Float priceToEarnings;
	
	private Company company;
	
	private List<Promotor> promotors;

}
