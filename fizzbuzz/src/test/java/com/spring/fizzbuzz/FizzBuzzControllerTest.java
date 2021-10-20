package com.spring.fizzbuzz;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.fizzbuzz.controller.FizzBuzzController;
import com.spring.fizzbuzz.model.InputRequest;
import com.spring.fizzbuzz.model.OutputResponse;
import com.spring.fizzbuzz.service.FizzBuzzService;


@WebMvcTest(FizzBuzzController.class)
public class FizzBuzzControllerTest {
	
	@MockBean
	FizzBuzzService service;
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	MockMvc mvc;
	
	private final static String URI = "/v1/api/fizzbuzz/calculate";
	
	@Test
    public void testFizzBuzzController_200() throws Exception {
        OutputResponse response1 = new OutputResponse("3","Fizz");
        OutputResponse response2 = new OutputResponse("5","Buzz");
        
        InputRequest input = new InputRequest();
        input.setInput(Arrays.asList("3","5"));
        
        List<OutputResponse> output = new ArrayList<>();
        output.add(response1);
        output.add(response2);
        
        Mockito.when(service.calculateFizzBuzz(any())).thenReturn(output);
        mvc.perform(post(URI)
        	.content(mapper.writeValueAsString(input))
        	.contentType(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
    }
	
	@Test
    public void testFizzBuzzController_JsonResponsePayload() throws Exception {
        OutputResponse response1 = new OutputResponse("3","Fizz");
        OutputResponse response2 = new OutputResponse("5","Buzz");
        
        InputRequest input = new InputRequest();
        input.setInput(Arrays.asList("3"));
        
        List<OutputResponse> output = new ArrayList<>();
        output.add(response1);
        output.add(response2);
        
        Mockito.when(service.calculateFizzBuzz(any())).thenReturn(output);
        mvc.perform(post(URI)
        	.content(mapper.writeValueAsString(input))
        	.contentType(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk())
        	.andExpect(MockMvcResultMatchers.jsonPath("$[0].divisionMessage").value("Fizz"))
        	.andExpect(MockMvcResultMatchers.jsonPath("$[1].divisionMessage").value("Buzz"));
    }
	
	
	

}
