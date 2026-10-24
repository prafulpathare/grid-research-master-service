package com.gridresearch.masterservice.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "stocks")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ticker")
	private String ticker;

	@Column(name = "price")
	private Double price;

	@Column(name = "market_cap")
	private Double marketCap;

	@Column(name = "pb")
	private Double priceToBook;

	@Column(name = "pe")
	private Double priceToEarnings;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id", referencedColumnName = "id")
	@JsonManagedReference // Marks this side as the forward reference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Company company;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock", cascade = CascadeType.ALL, orphanRemoval = false)
	@JsonManagedReference // Marks this side as the forward reference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Promotor> promotors = new ArrayList<>();
	
	public Stock addPromotor(Promotor promotor) {
		if(this.promotors == null) 
			this.promotors = new ArrayList<>();
		
		this.promotors.add(promotor);
		return this;
	}
}
