package com.bieger.restaurantapi.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bieger.restaurantapi.model.Admin;
import com.bieger.restaurantapi.repository.AdminRepository;
import com.bieger.restaurantapi.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	private final AdminRepository adminRepository;

	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	@Override
	public HashMap<Integer, Admin> findAll() {
		return (HashMap<Integer, Admin>) adminRepository.findAll();
	}

	@Override
	public Admin findById(Integer adminId) {
		return adminRepository.findById(adminId).get();
	}

	@Override
	public Admin save(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public Admin update(Integer adminId, Admin admin) {
		Admin adminUpdated = findById(adminId);
		adminUpdated.setUsername(admin.getUsername());
		adminUpdated.setPassword(admin.getPassword());
		adminUpdated.setRegisterCode(admin.getRegisterCode());
		return adminRepository.save(adminUpdated);
	}

	@Override
	public void deleteById(Integer adminId) {
		adminRepository.deleteById(adminId);
	}
	
}
