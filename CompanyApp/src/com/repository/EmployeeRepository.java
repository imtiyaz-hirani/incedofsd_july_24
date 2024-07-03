package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;

public class EmployeeRepository {
	/*
	 * Define variables
	 * */
	private String userDB = "root";
	private String passDB = "";
	private String dbName = "incedojuly24";
	private String url = "jdbc:mysql://localhost:3306/";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	private Connection conn; 
	
	public Connection dbConnect() {
		/*Step 1: Load the driver  */
		try {
			Class.forName(driver);
			//System.out.println("Driver loaded.. ");
		} catch (ClassNotFoundException e) {
			//System.out.println("Driver loading error..." + e.getMessage());
		}
		/* Step 2: Establish the connection */
		try {
			conn = DriverManager.getConnection(url + dbName, userDB, passDB);
			//System.out.println("Connection established...");
		} catch (SQLException e) {
			//System.out.println("Connection issue... " + e.getMessage());
		}
		
		return conn; 
	}
	
	public void dbClose() {
		try {
			conn.close();
			//System.out.println("Connection close");
		} catch (SQLException e) {
			 //System.out.println("conn close error " + e.getMessage());
		}
	}
	 
	public void insertEmployee(Employee employee) throws SQLException {
		dbConnect();
		String sql="insert into employee(name,salary,city,department,date_of_joining) values (?,?,?,?,?)";
		/* Prepare the statement  */
		PreparedStatement pstmt = conn.prepareStatement(sql);
		/* Assign values to placeholders(?)*/
		pstmt.setString(1, employee.getName());
		pstmt.setDouble(2, employee.getSalary());
		pstmt.setString(3, employee.getCity());
		pstmt.setString(4, employee.getDepartment());
		pstmt.setString(5, employee.getDateOfJoining().toString());
		/* Execute statement */
		pstmt.executeUpdate();
		dbClose();
	}

	public List<Employee> getAllEmployees() throws SQLException {
		dbConnect();
		ArrayList<Employee> list = new ArrayList<>();
		String sql="select * from employee";
		/* Prepare the statement  */
		PreparedStatement pstmt = conn.prepareStatement(sql);
		/* Assign values to placeholders(?)*/
		
		/* Execute statement */
		ResultSet rst = pstmt.executeQuery();
		
		while(rst.next()) {
			int id = rst.getInt("id");
			String name = rst.getString("name");
			double salary = rst.getDouble("salary");
			String city = rst.getString("city");
			String department = rst.getString("department");
			LocalDate dateOfJoining = LocalDate.parse(rst.getString("date_of_joining"));
			
			Employee employee = new Employee(id,name,city,department,salary,dateOfJoining); //100X 200X 300X 
			list.add(employee);
		}
		dbClose();
		return list;
	}
}

/* 
 * executeQuery() : fetch-select 
 * executeUpdate() : update,insert,delete
 * */
