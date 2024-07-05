package com.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.exception.MarksException;
import com.service.MainService;

public class MainServiceTest {

	MainService mainService = new MainService();
	
	@Test
	public void sumTest() {
		/* Use Case 1 : both positive numbers */
		int actualResult = mainService.sum(5, 5);
		int expectedResult = 10; 
		
		Assert.assertEquals(expectedResult, actualResult);
		
		/* Use Case 2 : both negative numbers */
		actualResult = mainService.sum(-5, -5);
		expectedResult = -10; 
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void addElementsFromListTest() {
		List<Integer> list = Arrays.asList(4,2,7,8,3); 
		int actualResult = mainService.addElementsFromList(list);
		int expectedResult = 24;
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void sortListTest() {
		/* Use Case 1: ASC  */
		List<Integer> list = Arrays.asList(4,2,7,8,3);
		List<Integer>  actualResult = mainService.sortList(list, "ASC");
		List<Integer> expectedResult = Arrays.asList(2,3,4,7,8);
		
		Assert.assertEquals(expectedResult, actualResult);
		
		/* Use Case 2: DESC  */
		actualResult = mainService.sortList(list, "DESC");
		expectedResult = Arrays.asList(8,7,4,3,2);
		
		Assert.assertEquals(expectedResult, actualResult);

		/* Use Case 3: Invalid sort  */
		list = Arrays.asList(4,2,7,8,3);
		actualResult = mainService.sortList(list, "INVALID");
		expectedResult = Arrays.asList(4,2,7,8,3);
		
		Assert.assertEquals(expectedResult, actualResult);

	}
	@Test
	public void computePercentTest() {
		/* Use Case 1: Valid Marks: B */
		List<Double> list = Arrays.asList(76.0,46.7,87.0);
		
		try {
			String actualGrade = mainService.computePercent(list);
			String expectedGrade = "B";
			
			Assert.assertEquals(expectedGrade, actualGrade);
		} catch (MarksException e) { }
		
		/* Use Case 2: Valid Marks : A */
		list = Arrays.asList(76.0,86.7,87.0);
		
		try {
			String actualGrade = mainService.computePercent(list);
			String expectedGrade = "A";
			
			Assert.assertEquals(expectedGrade, actualGrade);
		} catch (MarksException e) { }
		
		/* Use Case 3: inValid Marks : <0 */
		list = Arrays.asList(76.0,-86.7,87.0);
		
		try {
			String actualGrade = mainService.computePercent(list);
			String expectedGrade = "A";
			
			Assert.assertEquals(expectedGrade, actualGrade);
		} catch (MarksException e) { 
			Assert.assertEquals("Invalid Marks: marks cannot be <0", e.getMessage());

		}
		
		/* Use Case 4: inValid Marks : >110 */
		list = Arrays.asList(76.0,86.7,187.0);
		
		try {
			String actualGrade = mainService.computePercent(list);
			String expectedGrade = "A";
			
			Assert.assertEquals(expectedGrade, actualGrade);
		} catch (MarksException e) { 
			Assert.assertEquals("Invalid Marks: marks cannot be >100", e.getMessage());

		}
	}
}
