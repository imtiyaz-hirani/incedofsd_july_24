package com.hibernate.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.model.Course;
import com.hibernate.model.Department;
import com.hibernate.model.Student;
import com.hibernate.service.CourseService;
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
 			CourseService courseService = new CourseService(entityManager, transaction);
 			
			while(true) {
				System.out.println("***********COllege App**************");
				System.out.println("1. Add Student");
				System.out.println("2. Delete Student Record");
				System.out.println("3. List all Department");
				System.out.println("4. Add Department");
				System.out.println("5. Add Course");
				System.out.println("6. List of Students");
				System.out.println("7. List of Courses");
				System.out.println("8. Enroll student in Course");
				
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
				case 2: 
					try {
						studentService.deleteStudent();
						System.out.println("Student deleted...");
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break; 
				case 3: 
					try {
						List<Department> list =  courseService.getAllDepartment();
						System.out.println(list.size() == 0? "No records to display" 
									: "---List of Departments---");	
						list.stream().forEach(d -> System.out.println(d));
						 
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4: 
					try {
						courseService.addDepartment();
						System.out.println("Department added...");
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break; 
				case 5: 
					try {
						courseService.addCourse();
						System.out.println("Course added...");
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 6: 
					try {
						List<Student> list = studentService.getAllStudent();
						list.stream().forEach(s-> System.out.println(s));
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 7: 
					try {
						List<?> list =  courseService.getAllCourse();
						list.stream().forEach(c-> System.out.println(c));
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 8: 
					try {
						studentService.enrollStudentInCourse();
						System.out.println("student enrolled...");
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
