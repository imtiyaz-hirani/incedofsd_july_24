package com.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.service.LoginService;

public class MapDemo {
	public static void main(String[] args) {
		  //i/p
		Scanner sc = new Scanner(System.in);
		System.out.println("*****LOGIN********");
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		
		//reach out to service and pass inputs 
		LoginService loginService = new LoginService();
		boolean isValid  = loginService.validateCredentials(username,password);
		System.out.println(isValid?"Welcome " + username : "Login Denied");
		
		sc.close();
	}
}

/*
 *  Map   super-entity 
 *   |
 *  HashMap  sub-entity 
 *  
 *  Map takes <key,value> pair : Dictionary data structure 
 *  
 *  <"topic", <page-num>>
 *  
 *  key= username
 *  value = password 
 *  
 *  key=harry@gmail.com  : 
 *  value: potter@123    : 
 *  
 *  key=ronald@gmail.com
 *  value: weasley@123
 */