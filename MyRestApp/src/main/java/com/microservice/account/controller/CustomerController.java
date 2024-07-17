package com.microservice.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.account.dto.ResponseDto;
import com.microservice.account.exception.ResourceNotFoundException;
import com.microservice.account.model.Customer;
import com.microservice.account.model.Region;
import com.microservice.account.service.CustomerService;
import com.microservice.account.service.RegionService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private RegionService regionService; 
	
	@PostMapping("/api/customer/add/{regionId}")
	public ResponseEntity<?> postCustomer(@PathVariable("regionId") int regionId,
			@RequestBody Customer customer ) {
		/* fetch regionObj based on regionId */
		
		try {
			Region regionObj = regionService.getRegionById(regionId);
			/* set this regionObj to customer  */
			customer.setRegion(regionObj);
			/* save customer Object to DB  */
			customer =  customerService.addCustomer(customer);
			return ResponseEntity.ok().body(customer);
			
		} catch (ResourceNotFoundException e) {
			ResponseDto dto = new ResponseDto(e.getMessage(), "400");
			return ResponseEntity.badRequest().body(dto);
		}
		
	}
}
