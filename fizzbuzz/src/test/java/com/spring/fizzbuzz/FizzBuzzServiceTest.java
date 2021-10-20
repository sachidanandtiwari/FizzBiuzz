package com.spring.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.fizzbuzz.model.InputRequest;
import com.spring.fizzbuzz.model.OutputResponse;
import com.spring.fizzbuzz.service.FizzBuzzService;

@SpringBootTest
public class FizzBuzzServiceTest {
	
	@Autowired
	FizzBuzzService service;
	
	@Mock
	InputRequest request;
	
	@Test
	void contextLoads() {
	}
	
	
	
	@Test
	public void testcalculateFizzBuzzNewApproach_testFizzOneArrayElement() {
		
		List<String> inputList = new ArrayList<>();
		inputList.add("3");
		
		Mockito.when(request.getInput()).thenReturn(inputList);
		
		List<OutputResponse>response = service.calculateFizzBuzz(request);
		Assertions.assertEquals("Fizz", response.get(0).getDivisionMessage());
		
	}
	
	@Test
	public void testcalculateFizzBuzzNewApproach_testBuzzOneArrayElement() {
		
		List<String> inputList = new ArrayList<>();
		inputList.add("5");
		
		Mockito.when(request.getInput()).thenReturn(inputList);
		
		List<OutputResponse>response = service.calculateFizzBuzz(request);
		Assertions.assertEquals("Buzz", response.get(0).getDivisionMessage());
		
	}
	
	@Test
	public void testcalculateFizzBuzzNewApproach_testFizzBuzzOneArrayElement() {
		
		List<String> inputList = new ArrayList<>();
		inputList.add("90");
		
		Mockito.when(request.getInput()).thenReturn(inputList);
		
		List<OutputResponse>response = service.calculateFizzBuzz(request);
		Assertions.assertEquals("FizzBuzz", response.get(0).getDivisionMessage());
		
	}
	
	@Test
	public void testcalculateFizzBuzzNewApproach_testInvalidItemOneArrayElement() {
		
		List<String> inputList = new ArrayList<>();
		inputList.add("A");
		
		Mockito.when(request.getInput()).thenReturn(inputList);
		
		List<OutputResponse>response = service.calculateFizzBuzz(request);
		Assertions.assertEquals("Invalid Item", response.get(0).getDivisionMessage());
		
	}
	
	@Test
	public void testcalculateFizzBuzzNewApproach_testArrayOfValues() {
		
		List<String> inputList = new ArrayList<>();
		inputList.add("A");
		inputList.add("900");
		inputList.add("");
		inputList.add("2");
		
		Mockito.when(request.getInput()).thenReturn(inputList);
		
		List<OutputResponse>response = service.calculateFizzBuzz(request);
		Assertions.assertEquals("Invalid Item", response.get(0).getDivisionMessage());
		Assertions.assertEquals("FizzBuzz", response.get(1).getDivisionMessage());
		Assertions.assertEquals("Invalid Item", response.get(2).getDivisionMessage());
		Assertions.assertEquals("Divided 2 by 3 and"
				+ " Divided 2 by 5", response.get(3).getDivisionMessage());
		
	}
	
	@Test
	public void testcalculateFizzBuzzNewApproach_testCheckFizzRule() {
		Assertions.assertEquals(true,service.checkFizzRule("3"));
	}
	
	@Test
	public void testcalculateFizzBuzzNewApproach_testCheckBuzzRule() {
		Assertions.assertEquals(true,service.checkBuzzRule("5"));
	}
	
	@Test
	public void testcalculateFizzBuzzNewApproach_testCheckInvalidItemRule() {
		Assertions.assertEquals(true,service.checkInvalidItemRule("A"));
	}

}
