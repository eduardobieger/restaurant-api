package com.bieger.restaurantapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bieger.restaurantapi.model.ItemModel;
import com.bieger.restaurantapi.service.impl.ItemServiceImpl;

@RestController
@RequestMapping("api/v1/items")
public class ItemController {

	private final ItemServiceImpl itemService;

	public ItemController(ItemServiceImpl itemService) {
		this.itemService = itemService;
	}
	
	@GetMapping
	public ResponseEntity<List<ItemModel>> findAll() {
		return ResponseEntity.ok(itemService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<ItemModel> save(@RequestBody ItemModel item) {
		return ResponseEntity.ok(itemService.save(item));
	}
	
}
