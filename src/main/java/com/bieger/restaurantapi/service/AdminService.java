package com.bieger.restaurantapi.service;

import org.springframework.stereotype.Service;

import com.bieger.restaurantapi.repository.AdminRepository;

@Service
public class AdminService {

	private final AdminRepository adminRepository;

	public AdminService(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}
	
}
