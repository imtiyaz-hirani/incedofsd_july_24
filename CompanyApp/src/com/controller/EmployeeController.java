package com.controller;

import java.util.Scanner;

public class EmployeeController {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("*******Employee ops*********");
			System.out.println("1. Insert Employee");
			System.out.println("2. Fetch all Employees");
			System.out.println("3. delete an Employee");
			System.out.println("4. Update Employee Info");
			System.out.println("5. Filter Employee Data");
			System.out.println("6. Sort Employee Data");
			System.out.println("0. To Exit");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting Menu.. Thank you!!!");
				break; 
			}
			
			switch(input) {
				case 1:
					System.out.println("Insert Employee");
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				default: 
					System.out.println("Invalid Input.. Try Again");
			} //switch ends
		}//while ends
		sc.close();
	}//main ends
}//class ends
