package com.bieger.restaurantapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bieger.restaurantapi.model.Customer;
import com.bieger.restaurantapi.service.impl.CustomerServiceImpl;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

	private final CustomerServiceImpl customerService;

	public CustomerController(CustomerServiceImpl customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> findAll() {
		return ResponseEntity.ok().body(customerService.findAll());
	}
	
	@GetMapping("{customerId}")
	public ResponseEntity<Customer> findById(@PathVariable Integer customerId) {
		return ResponseEntity.ok().body(customerService.findById(customerId));
	}
	
	@PostMapping
	public ResponseEntity<Customer> save(@RequestBody Customer customer) {
		return ResponseEntity.ok().body(customerService.save(customer));
	}
	
	@PutMapping("{customerId}")
	public ResponseEntity<Customer> update(@PathVariable Integer customerId, @RequestBody Customer customer) {
		return ResponseEntity.ok().body(customerService.update(customerId, customer));
	}
	
	@DeleteMapping("{customerId}")
	public void delete(@PathVariable Integer customerId) {
		customerService.deleteById(customerId);
	}
	
}
