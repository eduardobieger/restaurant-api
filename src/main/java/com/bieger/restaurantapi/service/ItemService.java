package com.bieger.restaurantapi.service;

import java.util.List;

import com.bieger.restaurantapi.model.ItemModel;

public interface ItemService {

	public List<ItemModel> findAll();
	public ItemModel findById(Integer itemId);
	public ItemModel save(ItemModel item);
	public ItemModel update(Integer itemId, ItemModel item);
	public void delete(Integer itemId);
	
}
