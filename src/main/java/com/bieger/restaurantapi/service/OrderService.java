package com.bieger.restaurantapi.service;

import java.util.List;

import com.bieger.restaurantapi.model.Order;

public interface OrderService {
	
	public List<Order> findAll();
	public Order findById(Integer orderId);
	public Order save(Order order);
	public Order update(Order order);
	public void deleteById(Integer orderId);

}
