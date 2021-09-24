package com.empty_works.plain_emrs.util;

import java.util.Random;

final public class PasswordUtil {

	public static String generate(int length) {
		
		StringBuilder password = new StringBuilder("");
		
		System.out.println("Generating password...");
		for(int i = 0; i < length; i++) {
			
			password.append(getRandomChar());
		}
		
		return password.toString();
	}
	
	private static char getRandomChar() {
		
		String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		String digits = "1234567890";
		String symbols = "!<>_?$%)(&/=;:.,";
		
		Random rand = new Random();
		int randType = rand.nextInt(4); 
		switch(randType) {
		
		case 0: return uppercase.charAt(rand.nextInt(uppercase.length()));
		case 1: return lowercase.charAt(rand.nextInt(lowercase.length()));
		case 2: return digits.charAt(rand.nextInt(digits.length()));
		case 3: return symbols.charAt(rand.nextInt(symbols.length()));
		default: return 'a'; 
		}
	}
}
