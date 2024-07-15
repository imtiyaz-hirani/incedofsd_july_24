package com.hibernate.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.hibernate.model.Department;

public class CourseService {

	private EntityManager entityManager; 
	private EntityTransaction transaction;
	
	public CourseService(EntityManager entityManager, EntityTransaction transaction) {
		super();
		this.entityManager = entityManager;
		this.transaction = transaction;
	}

	public List<Department> getAllDepartment() {
		Query query = entityManager
						.createNativeQuery("select * from department", Department.class);
		
		@SuppressWarnings("unchecked")
		List<Department> list = query.getResultList();
		return list;
	} 
	 
	
}
