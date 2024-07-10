package com.hibernate.service;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.model.Address;
import com.hibernate.model.Student;

public class StudentService {

	private EntityManager entityManager;
	private EntityTransaction transaction; 
	private Student student; 
	private Address address; 
	
	Scanner sc;
	
	{
		sc = new Scanner(System.in);
	}
	
	public StudentService(EntityManager entityManager, EntityTransaction transaction) {
		 this.entityManager = entityManager;
		 this.transaction = transaction;
	}

	public void insertStudent() {
		student = new Student(); 
		address = new Address(); 
		
		/*Read values from user */
		System.out.println("Enter student name: ");
		student.setName(sc.next());
		System.out.println("Enter student email: ");
		student.setEmail(sc.next());
		System.out.println("Enter student city: ");
		address.setCity(sc.next());
		System.out.println("Enter student pincode: ");
		address.setPincode(sc.next());
		System.out.println("Enter student pnum: ");
		address.setPnum(sc.next());
		System.out.println("Enter student street: ");
		address.setStreet (sc.next());
		
		/*insert address first */
		//generate random id for address 
		int addressId = (int)(Math.random() * 1000000); 
		address.setId(addressId);
		
		transaction.begin();
		entityManager.persist(address);
		
		/* attach address to student */
		student.setAddress(address);
		 //generate random student id 
		int studentId = (int)(Math.random() * 1000000); 
		student.setId(studentId);
		 
		/*Insert student */
		entityManager.persist(student);
		transaction.commit();
	}

}
