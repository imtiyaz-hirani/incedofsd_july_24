package com.hibernate.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.hibernate.exception.ResourceNotFoundException;
import com.hibernate.model.Address;
import com.hibernate.model.Course;
import com.hibernate.model.Student;
import com.hibernate.model.StudentCourse;

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

	public void deleteStudent() throws ResourceNotFoundException {
		 System.out.println("Enter student id to delete");
		 int studentId = sc.nextInt();
		 /* Fetch student object and validate this ID. */
		 transaction.begin();
		 Student studentObj =  entityManager.find(Student.class, studentId);
		 transaction.commit();
		 if(studentObj == null)
			 throw new ResourceNotFoundException("Invalid id given...");
		 
		 Address addressObj = studentObj.getAddress();
		 transaction.begin();
		 /* delete student record */
		 entityManager.remove(studentObj);
		 /* delete address record */
		 entityManager.remove(addressObj);
		 transaction.commit();
		
	}

	public List<Student> getAllStudent() {
		transaction.begin();
		Query query =  entityManager.createNativeQuery("select * from student", Student.class);
		@SuppressWarnings("unchecked")
		List<Student> list = query.getResultList();
		transaction.commit();
		return list;
	}

	public void enrollStudentInCourse() throws ResourceNotFoundException {
		
		  /*1. Take student Id from user and validate it  */
		System.out.println("Enter Student ID");
		int studentId = sc.nextInt();
		transaction.begin();
		Student studentObj = entityManager.find(Student.class, studentId);
		transaction.commit();
		if(studentObj == null)
			throw new ResourceNotFoundException("Invalid student ID given");
		
		 /* 2. Take course  Id from user and validate it */
		System.out.println("Enter Course ID");
		int courseId = sc.nextInt();
		transaction.begin();
		Course courseObj = entityManager.find(Course.class, courseId);
		transaction.commit();
		if(courseObj == null)
			throw new ResourceNotFoundException("Invalid course ID given");
		
		/* 3. Attach student and course objs to StudentCourse obj along with date */
		StudentCourse sc = new StudentCourse();
		sc.setStudent(studentObj);
		sc.setCourse(courseObj);
		sc.setDateOfJoining(LocalDate.now());
		
		/* 4. persist studentcourse*/
		transaction.begin();
		entityManager.persist(sc);
		transaction.commit();
	}

	

}
