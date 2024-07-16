package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import com.model.Employee;

public class ListOfObjectsDemo {

	public static void main(String[] args) {
		System.out.println("Current thread name " +Thread.currentThread().getName());
		List<Employee> list = new ArrayList<>(); 
		Employee employee1 = new Employee(2,"harry potter","IT","london",88000D);
		Employee employee2 = new Employee(4,"ronald weasley","ADMIN","surrey",75000D);
		Employee employee3 = new Employee(1,"hermione granger","DEV","london",95000D);
		
		list = Arrays.asList(employee1,employee2,employee3);
		
		//iteration 
		for(Employee e : list) {
			System.out.println(e);
		}
		
		//sorting 
		Collections.sort(list); //e1.compareTo(e2)
		
		System.out.println("*********Sorted List by Salary : ASC*******");
		for(Employee e : list) {
			System.out.println(e);
		}
		
		
		/* Sorting using Comparator interface */
		System.out.println("*********Sorted List by Salary : ASC*******");
		Collections.sort(list, new A());
		for(Employee e : list) {
			System.out.println(e);
		}
		System.out.println("*********Sorted List by Salary : DESC*******");
		Collections.sort(list, new B());
		for(Employee e : list) {
			System.out.println(e);
		}
		System.out.println("*********Sorted List by CITY : ASC*******");
		Collections.sort(list, new C());
		for(Employee e : list) {
			System.out.println(e);
		}
	}
}

class A implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		 
		return (int)(e1.getSalary() - e2.getSalary());
	}
	
}

class B implements Comparator<Employee>{
	@Override
	public int compare(Employee e1, Employee e2) {
		 
		return (int)(e2.getSalary() - e1.getSalary());
	}
}

class C implements Comparator<Employee>{
	@Override
	public int compare(Employee e1, Employee e2) {
		
		return e1.getCity().compareTo(e1.getCity()) ;
	}
}