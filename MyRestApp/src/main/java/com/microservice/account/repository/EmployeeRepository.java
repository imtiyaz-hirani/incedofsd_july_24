package com.microservice.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.account.model.Employee;

public interface EmployeeRepository  
extends JpaRepository<Employee, Integer>{

	
}

/*
 * JpaRepository <I>
 * Obj save(Obj)		EntityManager:void persist(obj)
 * 		|
 *
 * EmployeeRepository <I>
 * 
 * Obj save(Obj)
 * List<T> findAll()
 * deleteById(id)
 * */
