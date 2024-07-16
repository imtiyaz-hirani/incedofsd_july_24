package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.exception.ResourceNotFoundException;
import com.model.Employee;
import com.service.EmployeeService;

public class EmployeeController {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		EmployeeService employeeService = new EmployeeService();
		while(true) {
			System.out.println("*******Employee ops*********");
			System.out.println("1. Insert Employee");
			System.out.println("2. Fetch all Employees");
			System.out.println("3. delete an Employee");
			System.out.println("4. Update Employee Info");
			System.out.println("5. Filter Employee Data");
			System.out.println("6. Sort Employee Data");
			System.out.println("7. Employee Stats for City");
			System.out.println("0. To Exit");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting Menu.. Thank you!!!");
				break; 
			}
			
			switch(input) {
				case 1:
					System.out.println("Insert Employee");
					System.out.println("Enter name: ");
					String name = sc.next();
					System.out.println("Enter salary: ");
					double salary = sc.nextDouble();
					System.out.println("Enter city: ");
					String city = sc.next();
					System.out.println("Enter department: ");
					String department = sc.next();
					System.out.println("Enter joining date: ");
					String dateOfJoining = sc.next();
					
					Employee employee = new Employee(0, name, city, 
							department, salary, LocalDate.parse(dateOfJoining));
					//reach out to service 
				try {
					employeeService.insertEmployee(employee);
					System.out.println("Employee record inserted..");
				} catch (SQLException e) {
					System.out.println("Insertion failed :" + e.getMessage()); 
				}
					
					break;
				case 2:
					System.out.println("----------List of Employees----------");
				List<Employee> list;
				try {
					list = employeeService.getAllEmployees();
					for(Employee emp : list) {
						System.out.println(emp);
					}
					System.out.println("--------------------------------------");
				} catch (SQLException e) {
					System.out.println("Error fetching records: " + e.getMessage());
				}
					
					break;
				case 3:
					System.out.println("Enter employee id to delete the record");
					int eid = sc.nextInt();			 
				try {
					employeeService.validateId(eid);
					//if i am here, then ID is valid
					//delete this record 
					employeeService.deleteEmployee(eid);
					System.out.println("Employee record deleted..");
				} catch (SQLException | ResourceNotFoundException e) {
					 System.out.println(e.getMessage());
				}
					break;
				case 4:
					System.out.println("Enter employee ID for update");
					eid = sc.nextInt();
				try {
					employee = employeeService.validateId(eid);
					System.out.println("Existing Record in DB");
					System.out.println(employee);
					System.out.println("Enter New Values to Update");
					System.out.println("Enter name: ");
					name = sc.next();
					System.out.println("Enter salary: ");
					salary = sc.nextDouble();
					System.out.println("Enter city: ");
					city = sc.next();
					System.out.println("Enter department: ");
					department = sc.next();
					//attach new values to exisitng object 
					employee.setName(name);
					employee.setSalary(salary);
					employee.setCity(city);
					employee.setDepartment(department);
					
					employeeService.updateEmployee(employee);
					System.out.println("Employee record updated... ");
					
				} catch (SQLException | ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
					break;
				case 5:
				try {
					list = employeeService.getAllEmployees();
					while(true){
						System.out.println("-----Filter menu--------");
						System.out.println("1. to filter by city");
						System.out.println("2. to filter by salary");
						System.out.println("3. to filter by department");
						System.out.println("4. to filter by date of joining");
						System.out.println("0 to exit");
						int filterInput = sc.nextInt();
						if(filterInput == 0)
							break; 
						
						switch(filterInput) {
						case 1: 
							System.out.println("Enter city value: ");
							List<Employee> filteredList = employeeService.filterEmployeeDataByCity(list, sc.next() );
							filteredList.stream().forEach(e->System.out.println(e));
							break;
						case 2: 
							System.out.println("Enter salary value: ");
							filteredList = employeeService.filterEmployeeDataBySalary(list, sc.nextDouble() );
							filteredList.stream().forEach(e->System.out.println(e));
							break; 
						case 3: 
							System.out.println("Enter department value: ");
							filteredList = employeeService.filterEmployeeDataByDapartment(list, sc.next() );
							filteredList.stream().forEach(e->System.out.println(e));
							break; 
						case 4: 
							System.out.println("Enter date of joining: ");
							filteredList = employeeService.filterEmployeeDataByDate(list, sc.next() );
							filteredList.stream().forEach(e->System.out.println(e));
							break; 
						default: 
							System.out.println("Invalid Input.. try again pls");
						}
							
					}
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				   break;
				case 6:
				try {
					list = employeeService.getAllEmployees();
					List<Employee> sortedList = employeeService.sortBYSalary(list,"DESC"); 
					sortedList.stream().forEach(e->System.out.println(e));
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
					break;
					
				case 7:
				try {
					list = employeeService.getAllEmployees();
					Map<String,Integer> map =  employeeService.statsByCity(list);
					System.out.println(map);
				} catch (SQLException e) {
					System.out.println(e.getMessage());

				}
					break; 
				default: 
					System.out.println("Invalid Input.. Try Again");
			} //switch ends
		}//while ends
		sc.close();
	}//main ends
}//class ends
