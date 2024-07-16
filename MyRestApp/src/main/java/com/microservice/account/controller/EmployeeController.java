package com.microservice.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.account.model.Employee;
import com.microservice.account.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/api/employee/add")
	public Employee postEmployee(@RequestBody Employee employee) {
		employee = employeeService.addEmployee(employee);
		return employee;
	}
	
	@GetMapping("/api/employee/getall")
	public List<Employee> getAllEmployee() {
		List<Employee> list = employeeService.getAllEmployee();
		return list; 
	}
	
	@DeleteMapping("/api/employee/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
		return "Employee deleted..";
	}
}
/*
 * @Autowired : is used to tell spring to create an object of this class for us. 
 * so that spring can close it out when the work is done 
 * so we are free from its maintenance
 * */

