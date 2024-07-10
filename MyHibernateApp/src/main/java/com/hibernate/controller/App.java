package com.hibernate.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import com.hibernate.model.Address;
import com.hibernate.model.Student;
import com.hibernate.service.AddressService;
import com.hibernate.service.StudentService;

public class App {

	public static void main(String[] args) {
		/*
		 * Reach out to persistence.xml file that hold DB connection settings thru
		 * persistence-unit: hibernate_incedojuly24 using EntityManagerFactory interface
		 */
		
		EntityManagerFactory sessionFactory = null; 
		EntityManager entityManager = null; 
		EntityTransaction transaction = null; 
		Scanner sc = new Scanner(System.in);
		
		try {
			/* Step 1 : Prepare SessionFactory obj */
			sessionFactory = Persistence.createEntityManagerFactory("hibernate_incedojuly24");

			/* Step 2 : Prepare EntityManager obj */
			entityManager = sessionFactory.createEntityManager();

			/* Step 3: Prepare EntityTransaction */
			transaction = entityManager.getTransaction();

			StudentService studentService = new StudentService(entityManager,transaction);
			AddressService addressService = new AddressService(entityManager,transaction);
			
			while(true) {
		 
				System.out.println("***********COllege App**************");
				System.out.println("1. Add Student");
				System.out.println("0.Exit");
				int input = sc.nextInt();
				if(input == 0) {
					System.out.println("Exiting.. Thanx...");
					break; 
				}
				
				switch(input) {
				case 1: 
					try {
						studentService.insertStudent();
						System.out.println("Student added in DB");
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break; 
				default: 
					System.out.println("invalid input given.. try again");
					break; 
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally { //release all resources 
			sc.close();
			entityManager.close();
			
		}
	}

}
