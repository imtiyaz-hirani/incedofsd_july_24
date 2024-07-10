package com.hibernate.service;

import javax.persistence.EntityManager;

import com.hibernate.model.Student;

public class StudentService {

	private EntityManager entityManager;
	
	public StudentService(EntityManager entityManager) {
		 this.entityManager = entityManager;
	}

	public void insertStudent(Student student) {
		entityManager.persist(student);
		
	}

}
