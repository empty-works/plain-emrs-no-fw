package com.empty_works.plain_emrs.util;

import java.util.HashMap;
import java.util.Map;

import com.empty_works.plain_emrs.util.helpers.FormValidationType;

public class FormValidationUtil {
	
	Map<String, String> errorMessages = new HashMap<>();
	boolean hasErrorMessages;
	
	public void validate(String input, String key, FormValidationType TYPE) {
		
		if(isEmpty(input)) {
			
			System.out.println("Form Validation Utility - input: " + input + " is empty...");

			put(key, "Cannot be empty.");
		}

		if(!TYPE.equals(FormValidationType.ONLYEMPTY)) {
			
			switch(TYPE) {
			
				case ALPHANUM: checkAlphaNum(input, key); 
				break;
				case ALPHA: checkLettersOnly(input, key);
				break;
				case NUM: checkNumbersOnly(input, key);
				break;
				default:
			}
		}
	}
	
	private void checkAlphaNum(String input, String key) {
		
		if(!input.matches("\\p{Alnum}+")) {
			
			put(key, "Please only enter letters or numbers.");
		}
	}
	
	private void checkLettersOnly(String input, String key) {
		
		if(!input.matches("\\d+")) {
			
			put(key, "Please only enter letters.");
		}
	}

	private void checkNumbersOnly(String input, String key) {
		
		if(input.matches("\\d+")) {
			
			put(key, "Please only enter numbers.");
		}
	}
	
	private boolean isEmpty(String input) {
		
		return input == null || input.trim().isEmpty();
	}
	
	private void put(String key, String message) {
		
		errorMessages.put(key, message);
		hasErrorMessages = true;
	}
	
	public Map<String, String> getErrorMessages() {
		
		return errorMessages; 
	}
	
	public boolean hasErrorMessages() {
		
		return hasErrorMessages;
	}
}
