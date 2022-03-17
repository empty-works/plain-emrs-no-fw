package com.empty_works.plain_emrs.util;

import java.util.HashMap;
import java.util.Map;

import com.empty_works.plain_emrs.util.helpers.FormValidationType;

public class FormValidationUtil {
	
	Map<String, String> errorMessages = new HashMap<>();
	boolean hasErrorMessages;
	
	public void validate(String input, FormValidationType TYPE) {
		
		if(isEmpty(input)) {

			put(input, "Cannot be empty.");
		}

		if(!TYPE.equals(FormValidationType.ONLYEMPTY)) {
			
			switch(TYPE) {
			
				case ALPHANUM: checkAlphaNum(input); 
				break;
				case ALPHA: checkLettersOnly(input);
				break;
				case NUM: checkNumbersOnly(input);
				break;
				default:
			}
		}
	}
	
	private void checkAlphaNum(String input) {
		
		if(!input.matches("\\p{Alnum}+")) {
			
			put(input, "Please only enter letters or numbers.");
		}
	}
	
	private void checkLettersOnly(String input) {
		
		if(!input.matches("\\d+")) {
			
			put(input, "Please only enter letters.");
		}
	}

	private void checkNumbersOnly(String input) {
		
		if(input.matches("\\d+")) {
			
			put(input, "Please only enter numbers.");
		}
	}
	
	private boolean isEmpty(String input) {
		
		return input == null || input.trim().isEmpty();
	}
	
	private void put(String input, String message) {
		
		errorMessages.put(input, message);
		hasErrorMessages = true;
	}
	
	public Map<String, String> getErrorMessages() {
		
		return errorMessages; 
	}
	
	public boolean hasErrorMessages() {
		
		return hasErrorMessages;
	}
}
