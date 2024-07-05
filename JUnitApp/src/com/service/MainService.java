package com.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.exception.MarksException;

public class MainService {

	/* addition on 2 nos. */
	
	public int sum(int x,int y) {
		return x+y; 
	}
	
	/* Add elements from given list */
	public int addElementsFromList(List<Integer> list) {
		int sum = 0; 
		for(int i : list) {
			sum = sum+i;
		}
		return sum;
	}
	
	/* Sort elements of given list */
	public List<Integer> sortList(List<Integer> list, String direction) {
		if(direction.equalsIgnoreCase("ASC")) {
			Collections.sort(list);
			return list; 
		}
		if(direction.equalsIgnoreCase("DESC")) {
			Collections.sort(list);
			Collections.reverse(list);
			return list; 
		}
		return list; 
	}
	
public String computePercent(List<Double> list) throws MarksException{
		
		for(double m : list) { //[87,92,76]
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
		for(double m : list) { //[87,92,76]
			totalMarks = totalMarks + m; 
		}
		double percent = (totalMarks * 100) / 300 ; 
		return percent > 75? "A":percent > 60?"B":"C";
		 
	}
}
