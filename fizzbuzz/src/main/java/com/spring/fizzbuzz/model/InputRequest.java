package com.spring.fizzbuzz.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;



public class InputRequest {
	
	@NotEmpty(message="List Cannot be Empty")
	private List<String> input;
	
	public List<String> getInput() {
		return input;
	}

	public void setInput(List<String> input) {
		this.input = input;
	}
	
	
	
	

}
