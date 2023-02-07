package com.bieger.restaurantapi.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "price", nullable = false)
	private BigDecimal price;
	
	@Column(name = "description")
	private String description;
	
//	@OneToMany(mappedBy = "items", cascade = CascadeType.ALL)
//	private List<Order> orders;
	
	public Item() {
		
	}

	public Item(Integer id, String title, BigDecimal price, String description) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
//		this.orders = orders;
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
	
//	public List<Order> getOrders() {
//		return orders;
//	}
//	
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}
	
}
