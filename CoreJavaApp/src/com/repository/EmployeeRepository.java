package com.repository;

import java.util.ArrayList;

import com.model.Employee;

public class EmployeeRepository {

	public ArrayList<Employee> fetchEmployee() {
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		Employee employee3 = new Employee();
		
		/* Attach instance variables(properties) values to this objects */
		employee1.setId(1);
		employee1.setName("harry potter");
		employee1.setCity("london");
		employee1.setDepartment("magic");
		
		employee2.setId(2);
		employee2.setName("ronald weasley");
		employee2.setCity("surrey");
		employee2.setDepartment("quidic");
		
		
		employee3.setId(3);
		employee3.setName("hermione granger");
		employee3.setCity("london");
		employee3.setDepartment("magic");
		
		/* Push these objects in list */
		ArrayList<Employee> list = new ArrayList<>();
		list.add(employee1); 
		list.add(employee2);
		list.add(employee3);
		return list;
	}

}

/* In OOP, objects are supposed to call and work with methods  */
