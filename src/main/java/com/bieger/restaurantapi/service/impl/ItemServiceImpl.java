package com.bieger.restaurantapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bieger.restaurantapi.model.ItemModel;
import com.bieger.restaurantapi.repository.ItemRepository;
import com.bieger.restaurantapi.service.ItemService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemServiceImpl implements ItemService {

	private final ItemRepository itemRepository;
	
	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ItemModel> findAll() {
		return itemRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ItemModel findById(Integer itemId) {
		return itemRepository.findById(itemId).get();
	}

	@Override
	@Transactional(readOnly = false)
	public ItemModel save(ItemModel item) {
		return itemRepository.save(item);
	}

	@Override
	@Transactional(readOnly = false)
	public ItemModel update(Integer itemId, ItemModel item) {
		ItemModel itemUpdated = findById(itemId);
		itemUpdated.setTitle(item.getTitle());
		itemUpdated.setPrice(item.getPrice());
		itemUpdated.setDescription(item.getDescription());
		return itemRepository.save(itemUpdated);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer itemId) {
		itemRepository.deleteById(itemId);
	}
	
}
