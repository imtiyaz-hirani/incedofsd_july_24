package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListDemo {
	public static void main(String[] args) {
		List<String>  list = new ArrayList<>(); //polymorphic 
		
		//add the elements 
		//1.1 
		list.add("harry");
		list.add("ronald"); 
		//[harry,ronald] -- 100X
		//1.2 
		list = Arrays.asList("harry","ronald","hermione"); 
		//list: 200X
		System.out.println(list);
		
		//iteration 
		for(String temp : list) {
			System.out.println(temp);
		}
		
		//fetch single element using index [harry,ronald hermione] 
		System.out.println(list.get(2)); //hermione 
		
		//finding an element 
		System.out.println(list.contains("RONALD".toLowerCase()));
		
		//sorting the string 
		List<Integer> listInt = Arrays.asList(5,2,4,8,1,9,6);
		Collections.sort(listInt); 
		System.out.println(listInt);
		
		//doing binary search on list 
		System.out.println(Collections.binarySearch(listInt, 7)> 0?"present" : "not present" );
	}
}
