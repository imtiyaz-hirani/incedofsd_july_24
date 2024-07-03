package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
	 
	public void insertEmployee(Employee employee) {
		dbConnect();
		String sql="";
		dbClose();
	}
}
