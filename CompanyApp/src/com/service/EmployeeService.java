package com.service;

import java.sql.SQLException;
import java.util.List;

import com.model.Employee;
import com.repository.EmployeeRepository;

public class EmployeeService {

	EmployeeRepository employeeRepository = 
			new EmployeeRepository();
	
	public void insertEmployee(Employee employee) throws SQLException {
		employeeRepository.insertEmployee(employee);
		
	}

	public List<Employee> getAllEmployees() throws SQLException {
		 
		return employeeRepository.getAllEmployees();
	}

}
