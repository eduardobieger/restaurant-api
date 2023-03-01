package com.bieger.restaurantapi.service;

import java.util.List;

import com.bieger.restaurantapi.model.OrderModel;

public interface OrderService {
	
	public List<OrderModel> findAll();
	public OrderModel findById(Integer orderId);
	public OrderModel save(OrderModel order);
	public OrderModel update(Integer orderId, OrderModel order);
	public void deleteById(Integer orderId);

}
