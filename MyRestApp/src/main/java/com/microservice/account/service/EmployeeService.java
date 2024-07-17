package com.microservice.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.account.exception.ResourceNotFoundException;
import com.microservice.account.model.Employee;
import com.microservice.account.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		
	}

	public Employee getEmployeeById(int id) throws ResourceNotFoundException {
		Optional<Employee> optional =  employeeRepository.findById(id);
		if(optional.isEmpty()) {
			throw new ResourceNotFoundException("Invalid Employee Id Given");
		}
		return optional.get();
	}

}

/* TO qualify for autowiring, EmployeeService must be a bean. 
 * so give annotation @Service  
 */