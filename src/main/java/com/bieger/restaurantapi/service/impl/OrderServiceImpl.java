package com.bieger.restaurantapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bieger.restaurantapi.model.Order;
import com.bieger.restaurantapi.repository.OrderRepository;
import com.bieger.restaurantapi.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;
	
	private final ItemServiceImpl itemService;
	
	private final UserServiceImpl userService;

	public OrderServiceImpl(OrderRepository orderRepository, ItemServiceImpl itemService, UserServiceImpl userService) {
		this.orderRepository = orderRepository;
		this.itemService = itemService;
		this.userService = userService;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Order findById(Integer orderId) {
		return orderRepository.findById(orderId).get();
	}

	@Override
	public Order save(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order update(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer orderId) {
		// TODO Auto-generated method stub
		
	}

}
