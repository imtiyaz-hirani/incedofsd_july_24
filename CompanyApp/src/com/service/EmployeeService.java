package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.exception.ResourceNotFoundException;
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

	public Employee validateId(int eid) throws SQLException, ResourceNotFoundException {
		return employeeRepository.validateId(eid);
		
	}

	public void deleteEmployee(int eid) throws SQLException {
		employeeRepository.deleteEmployee(eid);
		
	}

	public void updateEmployee(Employee employee) throws SQLException {
		employeeRepository.updateEmployee(employee);
		
	}

	public List<Employee> filterEmployeeDataByCity(List<Employee> list, String city) { 
		//[e1(mumbai),e2(london),e3(new york),e4(london)]
		return list.stream()
				.filter(e->e.getCity().equalsIgnoreCase(city) )
				.collect(Collectors.toList());
	}

	 
}
