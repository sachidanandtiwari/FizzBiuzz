package com.spring.fizzbuzz;



import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.spring.fizzbuzz.model.InputRequest;
import com.spring.fizzbuzz.model.OutputResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FizzBuzzIntegrationTest {
	
	@LocalServerPort
	int port;
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	private final static String URI = "/v1/api/fizzbuzz/calculate";
	
	
	
	@Test
	public void testFizzBuzzAPI_calculateFizzBuzzNew_200StatusCode() throws JsonProcessingException, Exception {
		InputRequest request = new InputRequest();
		request.setInput(Arrays.asList("3","5"));
		
		ResponseEntity<String> response = testRestTemplate.postForEntity("http://localhost:"+port+URI, request, String.class);
		Assertions.assertEquals(200, response.getStatusCodeValue());
		
	}
	
	@Test
	public void testFizzBuzzAPI_calculateFizzBuzzNew_500StatusCode() throws JsonProcessingException, Exception {
		InputRequest request = new InputRequest();
		request.setInput(Arrays.asList("3","5999999999999999999999999999"));
		ResponseEntity<String> response = testRestTemplate.postForEntity("http://localhost:"+port+URI, request, String.class);
		System.out.println(response.getStatusCodeValue());
		Assertions.assertEquals(500, response.getStatusCodeValue());
		
	}

	@Test
	public void testFizzBuzzAPI_calculateFizzBuzzNew_JsonResponsePayload() {
		InputRequest request = new InputRequest();
		request.setInput(Arrays.asList("3","5","15"));
		
		HttpEntity<InputRequest> requestEntity = new HttpEntity<InputRequest>(request);
		
		ParameterizedTypeReference<List<OutputResponse>> parameter =  new ParameterizedTypeReference<List<OutputResponse>>() {};
		ResponseEntity<List<OutputResponse>> response = testRestTemplate.exchange("http://localhost:"+port+URI,HttpMethod.POST,requestEntity,parameter);
		Assertions.assertEquals("Fizz",response.getBody().get(0).getDivisionMessage());
		Assertions.assertEquals("Buzz",response.getBody().get(1).getDivisionMessage());
		Assertions.assertEquals("FizzBuzz",response.getBody().get(2).getDivisionMessage());
	}
	
}
