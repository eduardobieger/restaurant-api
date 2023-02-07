package com.bieger.restaurantapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bieger.restaurantapi.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
