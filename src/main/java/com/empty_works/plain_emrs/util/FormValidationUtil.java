package com.empty_works.plain_emrs.util;

import java.util.HashMap;
import java.util.Map;

import com.empty_works.plain_emrs.util.helpers.FormValidationType;

public class FormValidationUtil {
	
	Map<String, String> errorMessages = new HashMap<>();
	
	public void validate(String input, FormValidationType TYPE) {
		
		switch(TYPE) {
		
			case ALPHANUM: checkAlphaNum(input); 
			break;
			case ALPHA: checkLettersOnly(input);
			break;
			case NUM: checkNumbersOnly(input);
			break;
			default:
		}
		errorMessages.put(input, "");
	}
	
	private String checkAlphaNum(String input) {
		
		if(isEmpty(input)) {
			errorMessages.put(input, "Cannot be empty.");
		}
		else if(!input.matches("\\p{Alnum}+")) {
			errorMessages.put(input, "Please only enter letters or numbers.");
		}
		return "";
	}
	
	private String checkLettersOnly(String input) {
		
		if(isEmpty(input)) {
			return "Cannot be empty";
		}
		else if(!input.matches("\\d+")) {
			return "Please only enter letters.";
		}
		return "";
	}

	private String checkNumbersOnly(String input) {
		
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
