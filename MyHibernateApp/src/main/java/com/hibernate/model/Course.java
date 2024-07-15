package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	@Column(nullable = false)
	private String name; 
	private String credits;
	private double fee;

	@ManyToOne
	private Department department;

	public Course(int id, String name, String credits, double fee, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.credits = credits;
		this.fee = fee;
		this.department = department;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", credits=" + credits + ", fee=" + fee + ", department="
				+ department + "]";
	}
	
	
	
}
