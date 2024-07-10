package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity   //create the table 
public class Student { //this shd be an entity 
	@Id  //this will make id as a primary key 
	private int id; 
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email; 
	
	//connect to the address class: relationship? M:1 address_id should be inserted in student
	@ManyToOne
	private Address address; //ref of class 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}
	
	
}
