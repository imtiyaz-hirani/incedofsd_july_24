package com.hibernate.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.hibernate.dto.EnrollDto;

public class EnrollService {
	private EntityManager entityManager; 
	private EntityTransaction transaction;
	
	private Scanner sc;
	
	{
		sc = new Scanner(System.in);
	}

	public EnrollService(EntityManager entityManager, EntityTransaction transaction ) {
		this.entityManager = entityManager;
		this.transaction = transaction;
	}

	public List<?> getEnrollStudentForAllCourses() {
		transaction.begin();
		String sql="select s.id as 'id',c.name as 'courseName' , count(s.id) as 'numberOfStudents' "
				+ " from student s JOIN student_course sc ON s.id=sc.student_id "
				+ " JOIN course c ON sc.course_id = c.id group by c.id";
		
		Query query = entityManager.createNativeQuery(sql,EnrollDto.class);
		
		List<?> list =  query.getResultList();
 		transaction.commit();
		return list;
	}
	//JPQL : 
	//create an entity class - but don't create a new table 
	
	
	
}
