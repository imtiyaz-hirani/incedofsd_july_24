package com.model;

public class Employee extends Object implements Comparable<Employee>{
	/* instance variables */
    private int id; 
    private String name; 
    private String department;
    private String city;
	private double salary; 

	public Employee(int id, String name, String department, String city, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.city = city;
		this.salary = salary;
	}
	
	

	public Employee() {
		 
	}



	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public String getCity() {
		return city;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", city=" + city + ", salary="
				+ salary + "]";
	}

	@Override
	public int compareTo(Employee e2) {
		 return (int) (this.salary - e2.salary);
	} 
	 //ASC - DESC:---ASC---- 
	//Employee - salary 
	//e1: 10000  e2: 12000 
	//[e1,e2] : [e1,e2]      e1.salary < e2.salary : no change :-ve
	
}//e1: 15000  e2: 12000 
//[e1,e2] : [e2,e1]      e1.salary > e2.salary : swap : +ve 
//e1: 12000  e2: 12000 
//[e1,e2] = [e1,e2] e1.salary == e2.salary : no change : 0 

 