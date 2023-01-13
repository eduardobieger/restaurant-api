package com.bieger.restaurantapi.service;

import java.util.HashMap;
import java.util.List;

import com.bieger.restaurantapi.model.Admin;

public interface AdminService {

	public HashMap<Integer, Admin> findAll();
	public Admin findById(Integer adminId);
	public Admin save(Admin admin);
	public Admin update(Integer adminId, Admin admin);
	public void deleteById(Integer adminId);
	
}
