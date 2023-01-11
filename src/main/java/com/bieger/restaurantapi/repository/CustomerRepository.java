package com.bieger.restaurantapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bieger.restaurantapi.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
