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

import com.bieger.restaurantapi.model.UserModel;
import com.bieger.restaurantapi.service.impl.UserServiceImpl;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

	private final UserServiceImpl userService;

	public UserController(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<UserModel>> findAll() {
		return ResponseEntity.ok().body(userService.findAll());
	}
	
	@GetMapping("{userId}")
	public ResponseEntity<UserModel> findById(@PathVariable Integer userId) {
		return ResponseEntity.ok().body(userService.findById(userId));
	}
	
	@PostMapping
	public ResponseEntity<UserModel> save(@RequestBody UserModel user) {
		return ResponseEntity.ok().body(userService.save(user));
	}
	
	@PutMapping("{userId}")
	public ResponseEntity<UserModel> update(@PathVariable Integer userId, @RequestBody UserModel user) {
		return ResponseEntity.ok().body(userService.update(userId, user));
	}
	
	@DeleteMapping("{userId}")
	public void delete(@PathVariable Integer userId) {
		userService.deleteById(userId);
	}
	
}
