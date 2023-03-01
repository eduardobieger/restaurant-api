package com.bieger.restaurantapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bieger.restaurantapi.model.OrderModel;
import com.bieger.restaurantapi.service.impl.OrderServiceImpl;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

	private final OrderServiceImpl orderService;

	public OrderController(OrderServiceImpl orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping
	public ResponseEntity<List<OrderModel>> findAll() {
		return ResponseEntity.ok(orderService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<OrderModel> save(@RequestBody OrderModel order) {
		return ResponseEntity.ok(orderService.save(order));
	}
}
