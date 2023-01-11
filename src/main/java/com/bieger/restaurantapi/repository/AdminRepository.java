package com.bieger.restaurantapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bieger.restaurantapi.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
