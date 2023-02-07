package com.bieger.restaurantapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bieger.restaurantapi.model.Item;
import com.bieger.restaurantapi.model.Order;
import com.bieger.restaurantapi.repository.OrderRepository;
import com.bieger.restaurantapi.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;
	private final ItemServiceImpl itemService;

	public OrderServiceImpl(OrderRepository orderRepository, ItemServiceImpl itemService) {
		this.orderRepository = orderRepository;
		this.itemService = itemService;
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
	@Transactional(readOnly = false)
	public Order save(Order order) {
		List<Item> itemsList = new ArrayList<>();
		for(Integer i = 1; i <= order.getItemsId().size(); i++) {			
			itemsList.add(itemService.findById(i));
		}
		order.setOrderItems(itemsList);
		return orderRepository.save(order);
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
