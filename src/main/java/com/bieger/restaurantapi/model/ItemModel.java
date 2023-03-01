package com.bieger.restaurantapi.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_tb")
public class ItemModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "price", nullable = false)
	private BigDecimal price;
	
	@Column(name = "description")
	private String description;
	
	@ManyToMany(mappedBy = "orderItems")
	@JsonIgnore
	private List<OrderModel> orders;
	
	public ItemModel() {
		
	}

	public ItemModel(Integer id, String title, BigDecimal price, String description, List<OrderModel> orders) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.orders = orders;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<OrderModel> getOrders() {
		return orders;
	}
	
	public void setOrders(List<OrderModel> orders) {
		this.orders = orders;
	}
	
}
