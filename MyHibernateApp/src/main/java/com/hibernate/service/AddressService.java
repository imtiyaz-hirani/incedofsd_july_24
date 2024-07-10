package com.hibernate.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.model.Address;

public class AddressService {

	private EntityManager entityManager;
	private EntityTransaction transaction; 
	
	 

	public AddressService(EntityManager entityManager, EntityTransaction transaction) {
	    this.entityManager = entityManager;
		this.transaction = transaction;
	}



	public void insertAddress(Address address) {
		 transaction.begin();
		  entityManager.persist(address);
		  transaction.commit();
	}
	
	 

}
