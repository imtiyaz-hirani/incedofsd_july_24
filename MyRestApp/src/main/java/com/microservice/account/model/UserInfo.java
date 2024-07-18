package com.microservice.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.microservice.account.enums.RoleType;

@Entity
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	@Column(nullable = false)
	private String username; 
	
	@Column(nullable = false,length = 512)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private RoleType role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleType getRole() {
		return role;
	}

	public void setRole(RoleType role) {
		this.role = role;
	} 
	
	
}
/*
 * String role = "ceo"
 * RoleType role = 
 * CUSTOMER,EMPLOYEE 
 * enum 
 * */
