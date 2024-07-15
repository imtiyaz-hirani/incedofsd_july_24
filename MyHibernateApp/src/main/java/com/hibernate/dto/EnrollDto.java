package com.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EnrollDto {

	@Id
	private int id; 
	private String courseName;
	private String numberOfStudents;

	public EnrollDto(String courseName, String numberOfStudents) {
		super();
		this.courseName = courseName;
		this.numberOfStudents = numberOfStudents;
	}

	public EnrollDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(String numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	@Override
	public String toString() {
		return "EnrollDto [courseName=" + courseName + ", numberOfStudents=" + numberOfStudents + "]";
	}

}
