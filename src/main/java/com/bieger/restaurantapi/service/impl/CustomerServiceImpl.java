package com.bieger.restaurantapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bieger.restaurantapi.model.Customer;
import com.bieger.restaurantapi.repository.CustomerRepository;
import com.bieger.restaurantapi.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	public Customer findById(Integer customerId) {
		return customerRepository.findById(customerId).get();
	}
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer update(Integer customerId, Customer customer) {
		Customer customerUpdated = findById(customerId);
		customerUpdated.setFirstName(customer.getFirstName());
		customerUpdated.setLastName(customer.getLastName());
		customerUpdated.setEmail(customer.getEmail());
		customerUpdated.setPhoneNumber(customer.getPhoneNumber());
		customerUpdated.setUsername(customer.getUsername());
		customerUpdated.setPassword(customer.getPassword());
		return customerRepository.save(customerUpdated);
	}
	
	public void deleteById(Integer customerId) {
		customerRepository.deleteById(customerId);
	}
	
}
