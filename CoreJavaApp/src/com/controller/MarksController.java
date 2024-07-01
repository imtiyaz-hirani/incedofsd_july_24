package com.controller;

import java.util.Scanner;

import com.service.MarksService;

public class MarksController {
	public static void main(String[] args) {
		/* I/P */
		System.out.println("Enter total number of subjects");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt(); //3
		double[] marks = new double[num]; //{0.0,0.0,0.0 }
		
		for(int i=0;i<num;i++) { //i=0,1,2 3... 
			System.out.println("Enter marks of subject " + (i+1));
			marks[i] = scanner.nextDouble(); //{87.0,92.5,76.0 }
		}
		
		/* Reach out to service : create an Object */
		MarksService marksService = new MarksService();
		String grade = marksService.computePercent(marks);
		
		/* o/p */
		System.out.println("Grade is " + grade);
		
		scanner.close();
	}
	
}

/* 
 * percent > 75 : A
 * 		   >60 : B
 * 				: C
 * */

/* class A: A aob=new A();  
 * Person Person person = new Person();
 * */
