package com.grid_research.master_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "promotor")
public class Promotor {
	
	@Id
	private Long id;
	
	@Column
	private String name;

}
