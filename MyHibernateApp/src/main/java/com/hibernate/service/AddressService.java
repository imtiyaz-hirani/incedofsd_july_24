package com.hibernate.service;

import javax.persistence.EntityManager;

import com.hibernate.model.Address;

public class AddressService {

	private EntityManager entityManager;

	public AddressService(EntityManager entityManager) {
		 this.entityManager = entityManager;
	}

	public void insertAddress(Address address) {
		  entityManager.persist(address);
	}
	
	 

}
