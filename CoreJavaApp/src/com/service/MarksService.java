package com.service;

import java.util.ArrayList;

import com.exception.MarksException;

public class MarksService {

	public String computePercent(double[] marks) throws MarksException{
		
		for(double m : marks) { //[87,92,76]
			if(m >100) {
				//throw an exception
				throw new MarksException("Invalid Marks: marks cannot be >100"); 
			}
			
			if(m<0) {
				//throw an exception
				throw new MarksException("Invalid Marks: marks cannot be <0"); 
			}
		}
		
		double totalMarks = 0; 
		for(double m : marks) { //[87,92,76]
			totalMarks = totalMarks + m; 
		}
		double percent = (totalMarks * 100) / 300 ; 
		return percent > 75? "A":percent > 60?"B":"C";
		 
	}
	
	/* 
	 * if value of any of the marks is >100 or is <0 then its "Invalid Marks"
	 * */

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
