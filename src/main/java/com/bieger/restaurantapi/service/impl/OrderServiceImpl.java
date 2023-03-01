package com.bieger.restaurantapi.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bieger.restaurantapi.model.ItemModel;
import com.bieger.restaurantapi.model.OrderModel;
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
	public List<OrderModel> findAll() {
		return orderRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public OrderModel findById(Integer orderId) {
		return orderRepository.findById(orderId).get();
	}

	@Override
	@Transactional(readOnly = false)
	public OrderModel save(OrderModel order) {
		List<ItemModel> itemsList = new ArrayList<>();
		BigDecimal totalPrice = new BigDecimal("0");
		for(Integer i = 1; i <= order.getItemsId().size(); i++) {			
			itemsList.add(itemService.findById(i));
			totalPrice = totalPrice.add(itemService.findById(i).getPrice());
		}
		order.setOrderItems(itemsList);
		order.setTotalPrice(totalPrice);
		return orderRepository.save(order);
	}

	@Override
	public OrderModel update(Integer orderId, OrderModel order) {
		OrderModel updatedOrder = findById(orderId);
		updatedOrder.setUserId(order.getUserId());
		updatedOrder.setItemsId(order.getItemsId());
		return null;
	}

	@Override
	public void deleteById(Integer orderId) {
		orderRepository.deleteById(orderId);
	}

}
