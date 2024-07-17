package com.microservice.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.account.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	List<Customer> findByRegionId(int regionId);

}
/* 
 * JpaRepository has contract with developers:
 * 
 * it has some inbuilt methods which developers can use straight away  
 * 
 * JPARepo also allows developers to define instance variable methods. 
 * ex. Customer class has 4 instance variables: 
 * id (findById),name,contact,region 
 * 
 * Customer findByName(String name);
 * Customer findByContact(String contact);
 * List<Customer> findByRegionId(int id);
 */