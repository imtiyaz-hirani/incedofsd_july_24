package com.hibernate.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.hibernate.exception.ResourceNotFoundException;
import com.hibernate.model.Course;
import com.hibernate.model.Department;

public class CourseService {

	private EntityManager entityManager; 
	private EntityTransaction transaction;
	
	private Scanner sc;
	
	{
		sc = new Scanner(System.in);
	}
	public CourseService(EntityManager entityManager, EntityTransaction transaction) {
		super();
		this.entityManager = entityManager;
		this.transaction = transaction;
	}

	public List<Department> getAllDepartment() {
		transaction.begin();
		Query query = entityManager
						.createNativeQuery("select * from department", Department.class);
		
		@SuppressWarnings("unchecked")
		List<Department> list = query.getResultList();
		transaction.commit();
		return list;
	}

	public void addDepartment() {
		transaction.begin();
		System.out.println("Enter department name");
		Department department = new Department(); 
		department.setName(sc.next());
		entityManager.persist(department);
		transaction.commit();
	}

	public void addCourse() throws ResourceNotFoundException {
		transaction.begin();
		/* take department id from user and fetch departmentObj */
		System.out.println("Enter department id");
		int deptId = sc.nextInt();
		Department department = entityManager.find(Department.class, deptId);
		if(department == null)
			throw new ResourceNotFoundException("Invalid Id Given");
		
		/* take course field values from user */
		Course course = new Course(); 
		System.out.println("Enter course name");
		sc.nextLine();
		course.setName(sc.nextLine());
		System.out.println("Enter course credits");
		course.setCredits(sc.next());
		System.out.println("Enter course fee");
		course.setFee(sc.nextDouble());
		
		/* Attach departmentObj to courseObj */
		course.setDepartment(department);
		/* persist course */
		entityManager.persist(course);
		transaction.commit();
	}

	public List<?> getAllCourse() {
		transaction.begin();
		Query query= entityManager.createNativeQuery("select * from course", Course.class);
		List<?> list = query.getResultList();
		transaction.commit();
		return list;
	} //? : i dont know or can;t say right now what my list generically will have
	 
	
}
