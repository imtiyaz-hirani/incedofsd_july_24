package com.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	public List<Employee> filterEmployeeDataByCity(List<Employee> list, String city) { //london
		//[e1(mumbai),e2(london),e3(new york),e4(london)]
		return list.stream()
				.filter(e->e.getCity().equalsIgnoreCase(city) )
				.collect(Collectors.toList());
	}

	public List<Employee> filterEmployeeDataBySalary(List<Employee> list, double salary) {
		return list.stream()
		.filter(e->e.getSalary() >= salary)
		.collect(Collectors.toList());
		 
	}

	public List<Employee> filterEmployeeDataByDapartment(List<Employee> list, String dept) {
		return list.stream()
				.filter(e->e.getDepartment().equalsIgnoreCase(dept))
				.collect(Collectors.toList());
	}

	public List<Employee> filterEmployeeDataByDate(List<Employee> list, String dateOfJoining) {
		return list.stream()
				.filter(e->e.getDateOfJoining().compareTo(LocalDate.parse(dateOfJoining)) > 1)
				.collect(Collectors.toList());
	}

	public List<Employee> sortBYSalary(List<Employee> list, String direction) {
		List<Employee> sortedList = 
				list.stream()
					.sorted(Comparator.comparing(e->e.getSalary()))
					.collect(Collectors.toList());
		
		if(direction .equals("ASC"))
			return sortedList; 
		else {
			Collections.reverse(sortedList);
			return sortedList;
		}
	}

	public Map<String, Integer> statsByCity(List<Employee> list) {
		Map<String, Integer> map = new HashMap<>();
		List<String>  listCities = list.stream()
									.map(e->e.getCity())
									.distinct()
									.collect(Collectors.toList());  //[london, surrey, manchester]
		
		listCities.stream().forEach(city->{  //[london, surrey, manchester]
			int count = (int) list.stream().filter(e->e.getCity().equals(city)).count();
			map.put(city, count);
		}); 
		return map;
	}
}
