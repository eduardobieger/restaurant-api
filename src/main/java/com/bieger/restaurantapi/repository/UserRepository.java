package com.bieger.restaurantapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bieger.restaurantapi.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

}
