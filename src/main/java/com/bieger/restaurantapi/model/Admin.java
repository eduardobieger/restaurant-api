package com.bieger.restaurantapi.model;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User {

	private int registerCode;

	public int getRegisterCode() {
		return registerCode;
	}

	public void setRegisterCode(int registerCode) {
		this.registerCode = registerCode;
	}
	
}
