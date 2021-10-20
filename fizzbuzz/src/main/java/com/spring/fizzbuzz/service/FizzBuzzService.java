package com.spring.fizzbuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.spring.fizzbuzz.model.InputRequest;
import com.spring.fizzbuzz.model.OutputResponse;
import org.apache.commons.lang3.math.NumberUtils;

@Service
public class FizzBuzzService {

	Logger logger = LoggerFactory.getLogger(FizzBuzzService.class);

	@Value("${input.firstno}")
	int firstno;

	@Value("${input.secondno}")
	int secondno;

	

	public List<OutputResponse> calculateFizzBuzz(InputRequest request) {
		List<OutputResponse> outputList = new ArrayList<OutputResponse>();
		List<String> inputList = request.getInput();
		for (String object : inputList) {
			OutputResponse output = new OutputResponse();
			
			if (checkInvalidItemRule(object)) {
				output.setInputNo(object.toString());
				output.setDivisionMessage("Invalid Item");
			}else if (checkFizzRule(object) && checkBuzzRule(object)) {
				output.setInputNo(object.toString());
				output.setDivisionMessage("FizzBuzz");
			} else if (checkFizzRule(object)) {
				output.setInputNo(object.toString());
				output.setDivisionMessage("Fizz");
			} else if (checkBuzzRule(object)) {
				output.setInputNo(object.toString());
				output.setDivisionMessage("Buzz");
			} else {
				StringBuilder builder = new StringBuilder();
				builder.append("Divided ")
						.append(object.toString())
						.append(" by ")
						.append(firstno)
						.append(" and")
						.append(" Divided ")
						.append(object.toString())
						.append(" by ")
						.append(secondno);
				output.setInputNo(object.toString());
				output.setDivisionMessage(builder.toString());
			}

			outputList.add(output);
		}
		return outputList;

	}
	
	public boolean checkFizzRule(String object) {
		
		if((NumberUtils.isParsable(object) && Integer.parseInt(object.toString()) % firstno == 0)) {
			return true;
		}
		return false;
		
	}
	
	public boolean checkBuzzRule(String object) {
		
		if((NumberUtils.isParsable(object) && Integer.parseInt(object.toString()) % secondno == 0)) {
			return true;
		}
		return false;
	}
	
	public boolean checkInvalidItemRule(String object) {
		
		if(!(NumberUtils.isParsable(object))) {
			return true;
		}
		return false;
	}
	
	
	
	

}