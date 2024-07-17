package com.microservice.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.account.model.Customer;
import com.microservice.account.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	public Customer addCustomer(Customer customer) {
		 
		return customerRepository.save(customer);
	}

}
