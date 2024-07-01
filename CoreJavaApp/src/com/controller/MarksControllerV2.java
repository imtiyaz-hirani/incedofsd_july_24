package com.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.service.MarksService;

public class MarksControllerV2 {
	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<>();
		/* i/p */
		Scanner scanner = new Scanner(System.in);
		int i=0;
		System.out.println("Press -1 to exit");
		while(i<100000) {
			System.out.println("Enter marks of subjects");
			double in = scanner.nextDouble(); 
			if(in == -1)
				break; 
			list.add(in);
			i++;
			
		}
		 
		/* Reach out to service : create an Object */
		MarksService marksService = new MarksService();
		String grade = marksService.computePercent(list);
		/* o/p */
		System.out.println("Grade is " + grade);
		scanner.close();
	}
}
