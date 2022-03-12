package com.empty_works.plain_emrs.util;

public class FormValidationUtil {

	public static String checkAlphaNum(String input) {
		
		if(isEmpty(input)) {
			return "Cannot be empty.";
		}
		else if(!input.matches("\\p{Alnum}+")) {
			return "Please only enter letters or numbers.";
		}
		return "";
	}
	
	public static String checkLettersOnly(String input) {
		
		if(isEmpty(input)) {
			return "Cannot be empty";
		}
		else if(!input.matches("\\d+")) {
			return "Please only enter letters.";
		}
		return "";
	}

	public static String checkNumbersOnly(String input) {
		
		if(isEmpty(input)) {
			return "Cannot be empty";
		}
		else if(input.matches("\\d+")) {
			return "Please only enter numbers.";
		}
		return "";
	}
	
	private static boolean isEmpty(String input) {
		
		return input == null || input.trim().isEmpty();
	}
}
