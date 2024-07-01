package com.controller;

import java.util.ArrayList;

import com.model.Employee;
import com.service.EmployeeService;

public class EmployeeController {
	public static void main(String[] args) {
		//Reach out to EmployeeService 
		EmployeeService employeeService = new EmployeeService();
		ArrayList<Employee> earry = employeeService.fetchEmployee();
		
		/* o/p */
		for(Employee e : earry) { 
			System.out.println(e.getId() + "   " + e.getName() + "  " + e.getDepartment());
		}
		
	}
}
