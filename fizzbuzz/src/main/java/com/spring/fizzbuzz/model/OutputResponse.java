package com.spring.fizzbuzz.model;

public class OutputResponse {

	private String inputNo;
	
	private String divisionMessage;
	
	public OutputResponse() {
		
	}
	
	public OutputResponse(String inputNo, String divisionMessage) {
		super();
		this.inputNo = inputNo;
		this.divisionMessage = divisionMessage;
	}
	
	public String getInputNo() {
		return inputNo;
	}
	public void setInputNo(String inputNo) {
		this.inputNo = inputNo;
	}
	public String getDivisionMessage() {
		return divisionMessage;
	}
	public void setDivisionMessage(String divisionMessage) {
		this.divisionMessage = divisionMessage;
	}
}
