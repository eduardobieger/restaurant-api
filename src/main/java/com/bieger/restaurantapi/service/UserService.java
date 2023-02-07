package com.bieger.restaurantapi.service;

import java.util.List;

import com.bieger.restaurantapi.model.User;

public interface UserService {

	public List<User> findAll();
	public User findById(Integer userId);
	public User save(User user);
	public User update(Integer userId, User user);
	public void deleteById(Integer userId);
	
}
