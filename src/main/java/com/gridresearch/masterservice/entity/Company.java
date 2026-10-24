package com.grid_research.master_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "company")
public class Company {
	
	@Id
	private Long id;
	
	@Column(name = "name")
	private String name;

}
