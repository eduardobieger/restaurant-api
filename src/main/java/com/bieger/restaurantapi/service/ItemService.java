package com.bieger.restaurantapi.service;

import java.util.List;

import com.bieger.restaurantapi.model.Item;

public interface ItemService {

	public List<Item> findAll();
	public Item findById(Integer itemId);
	public Item save(Item item);
	public Item update(Integer itemId, Item item);
	public void delete(Integer itemId);
	
}
