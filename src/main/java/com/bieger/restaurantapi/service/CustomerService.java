package com.bieger.restaurantapi.service;

import java.util.List;

import com.bieger.restaurantapi.model.Customer;

public interface CustomerService {

	public List<Customer> findAll();
	public Customer findById(Integer customerId);
	public Customer save(Customer customer);
	public Customer update(Integer customerId, Customer customer);
	public void deleteById(Integer customerId);
	
}
