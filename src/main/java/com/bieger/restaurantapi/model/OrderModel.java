package com.bieger.restaurantapi.model;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_tb")
public class OrderModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "total_price")
	private BigDecimal totalPrice = new BigDecimal("0");

	private Integer userId;
	
	@Column(name = "items_id")
	private List<Integer> itemsId;
	
	@ManyToOne(targetEntity = UserModel.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private UserModel orderUser;
	

	@ManyToMany
	@JoinTable(
			name = "order_items_tb",
			joinColumns = @JoinColumn(name = "order_id"),
			inverseJoinColumns = @JoinColumn(name = "item_id")
	)
	@JsonIgnore
	private List<ItemModel> orderItems;
	
	public OrderModel() {
		
	}

	public OrderModel(Integer id, BigDecimal totalPrice, Integer userId, List<Integer> itemsId, UserModel orderUser,
					  List<ItemModel> orderItems) {
		this.id = id;
		this.totalPrice = totalPrice;
		this.userId = userId;
		this.itemsId = itemsId;
		this.orderUser = orderUser;
		this.orderItems = orderItems;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<Integer> getItemsId() {
		return itemsId;
	}

	public void setItemsId(List<Integer> itemsId) {
		this.itemsId = itemsId;
	}

	public UserModel getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(UserModel orderUser) {
		this.orderUser = orderUser;
	}

	public List<ItemModel> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<ItemModel> orderItems) {
		this.orderItems = orderItems;
	}
	
}
