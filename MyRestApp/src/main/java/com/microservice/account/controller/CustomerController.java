package com.microservice.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.account.model.Customer;
import com.microservice.account.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/api/customer/add/{regionId}")
	public void postCustomer(@PathVariable("regionId") int regionId,
			@RequestBody Customer customer ) {
		/* fetch regionObj based on regionId */
		
		/* set this regionObj to customer  */
		
		/* save customer Object to DB  */
	}
}
