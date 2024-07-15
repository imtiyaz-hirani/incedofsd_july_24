package com.hibernate.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_course")
public class StudentCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	@Column(name = "date_of_joining")
	private LocalDate dateOfJoining;
	
	@ManyToOne
	private Student student; 
	
	@ManyToOne
	private Course course;
 

	public StudentCourse(int id, LocalDate dateOfJoining, Student student, Course course) {
		super();
		this.id = id;
		this.dateOfJoining = dateOfJoining;
		this.student = student;
		this.course = course;
	}


	public StudentCourse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}


	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	@Override
	public String toString() {
		return "StudentCourse [id=" + id + ", dateOfJoining=" + dateOfJoining + ", student=" + student + ", course="
				+ course + "]";
	}

 
	
}
