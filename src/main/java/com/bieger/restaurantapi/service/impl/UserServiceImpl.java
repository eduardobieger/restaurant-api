package com.bieger.restaurantapi.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.bieger.restaurantapi.model.User;
import com.bieger.restaurantapi.repository.UserRepository;
import com.bieger.restaurantapi.service.UserService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public User findById(Integer userId) {
		return userRepository.findById(userId).get();
	}
	
	@Override
	@Transactional(readOnly = false)
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Override
	@Transactional(readOnly = false)
	public User update(Integer userId, User user) {
		User userUpdated = findById(userId);
		userUpdated.setFirstName(user.getFirstName());
		userUpdated.setLastName(user.getLastName());
		userUpdated.setEmail(user.getEmail());
		userUpdated.setPhoneNumber(user.getPhoneNumber());
		userUpdated.setUsername(user.getUsername());
		userUpdated.setPassword(user.getPassword());
		return userRepository.save(userUpdated);
	}
	
	@Override
	@Transactional(readOnly = false)
	public void deleteById(Integer userId) {
		userRepository.deleteById(userId);
	}
	
}
