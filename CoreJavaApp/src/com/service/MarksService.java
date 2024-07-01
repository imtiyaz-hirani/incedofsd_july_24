package com.service;

import java.util.ArrayList;

public class MarksService {

	public String computePercent(double[] marks) {
		double totalMarks = 0; 
		for(double m : marks) { //[87,92,76]
			totalMarks = totalMarks + m; 
		}
		double percent = (totalMarks * 100) / 300 ; 
		return percent > 75? "A":percent > 60?"B":"C";
		 
	}

	public String computePercent(ArrayList<Double> list) {
		double totalMarks = 0; 
		for(double m : list) { //[87,92,76]
			totalMarks = totalMarks + m; 
		}
		double percent = (totalMarks * 100) / 300 ; 
		return percent > 75? "A":percent > 60?"B":"C";
	}
}

/* 
 * double totalMarks = marks1 + marks2 + marks3; 
		double percent = (totalMarks * 100) / 300 ; 
		return percent > 75? "A":percent > 60?"B":"C";
		
 * */
