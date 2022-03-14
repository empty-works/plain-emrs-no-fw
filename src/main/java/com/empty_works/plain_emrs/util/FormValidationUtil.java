package com.empty_works.plain_emrs.util;

import java.util.HashMap;
import java.util.Map;

public class FormValidationUtil {
	
	Map<String, String> errorMessages = new HashMap<>();
	
	public void validate(String input) {
		errorMessages.put(input, "");
	}
	
	public String checkAlphaNum(String input) {
		
		if(isEmpty(input)) {
			errorMessages.put(input, "Cannot be empty.");
		}
		else if(!input.matches("\\p{Alnum}+")) {
			errorMessages.put(input, "Please only enter letters or numbers.");
		}
		return "";
	}
	
	public String checkLettersOnly(String input) {
		
		if(isEmpty(input)) {
			return "Cannot be empty";
		}
		else if(!input.matches("\\d+")) {
			return "Please only enter letters.";
		}
		return "";
	}

	public String checkNumbersOnly(String input) {
		
		if(isEmpty(input)) {
			return "Cannot be empty";
		}
		else if(input.matches("\\d+")) {
			return "Please only enter numbers.";
		}
		return "";
	}
	
	private boolean isEmpty(String input) {
		
		return input == null || input.trim().isEmpty();
	}
}
