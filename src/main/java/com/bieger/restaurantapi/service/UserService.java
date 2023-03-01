package com.bieger.restaurantapi.service;

import java.util.List;

import com.bieger.restaurantapi.model.UserModel;

public interface UserService {

	public List<UserModel> findAll();
	public UserModel findById(Integer userId);
	public UserModel save(UserModel user);
	public UserModel update(Integer userId, UserModel user);
	public void deleteById(Integer userId);
	
}
