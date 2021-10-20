package com.spring.fizzbuzz.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.fizzbuzz.model.InputRequest;
import com.spring.fizzbuzz.model.OutputResponse;
import com.spring.fizzbuzz.service.FizzBuzzService;

@RestController
@RequestMapping("/v1/api/fizzbuzz")
@Validated
public class FizzBuzzController {
	
	@Autowired
	FizzBuzzService service;
	
	Logger logger = LoggerFactory.getLogger(FizzBuzzController.class);
	
	@PostMapping("/calculate")
	public ResponseEntity<List<OutputResponse>> calculateFizzBuzz(@Valid @RequestBody InputRequest request){
		logger.info("Inside Controller");
		return new ResponseEntity<>(service.calculateFizzBuzz(request),HttpStatus.OK);
		
	}
	
}
