package com.bieger.restaurantapi.model;

import java.math.BigDecimal;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Item {

	private Integer id;
	private String title;
	private BigDecimal price;
	
}
