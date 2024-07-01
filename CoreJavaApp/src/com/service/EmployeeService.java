package com.service;

import java.util.ArrayList;

import com.model.Employee;
import com.repository.EmployeeRepository;

public class EmployeeService {

	//Reach out to Repository 
	EmployeeRepository employeeRepository = new EmployeeRepository();

	public ArrayList<Employee> fetchEmployee() {
		// go to repository and fetch the data 
		ArrayList<Employee> earry = employeeRepository.fetchEmployee();
		return earry;
	}
}
