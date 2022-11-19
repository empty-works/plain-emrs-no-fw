package com.empty_works.plain_emrs.util.helpers;

import java.time.LocalDate;
import java.util.Random;

public class IdUtil {

	final public static String INVALID = "Invalid ID due to invalid inputs.";

	final public static String get(String...texts) {
		
		StringBuilder idSb = new StringBuilder();
		idSb.append(getFirstPartId(texts));
		idSb.append(getRandomSequence());
		
		System.out.println("Final non-patient ID: " + idSb.toString());
		return idSb.toString();
	}
	
	protected static String getFirstPartId(String...texts) {
		
		String lowercase = "abcdefghijklmnopqrstuvwxyz0123456789-_/";
		
		StringBuilder namesSb = new StringBuilder();
		for(String text : texts) {
			
			String tempSub = getNameSub(text);
			
			namesSb.append(normalizeIndex(lowercase.indexOf(Character.toLowerCase(tempSub.charAt(0)))));
			if(tempSub.length() > 1) namesSb.append(normalizeIndex(lowercase.indexOf(
					Character.toLowerCase(tempSub.charAt(1)))));
			else namesSb.append("00");
		}

		return namesSb.toString();
	}

	// getNameId helper
	private static String getNameSub(String name) {
		
		return (name.length() > 1) ? "" + name.charAt(0) + name.charAt(1) : "" + name.charAt(0);
	}
	
	protected static String getDobId(LocalDate dob) {
		
		return DateOfBirthUtil.getDobId(dob);
	}
	
	// Creates sequence based on current time in milliseconds
	public final static int SEQUENCE_LENGTH = 4;
	protected static String getRandomSequence() {
		
		final int SEQUENCE_BOUND = 1000;
		final int START_SEQUENCE = 1;
		final int END_SEQUENCE = 7;
		StringBuilder seqSb = new StringBuilder();

		// Calculate seconds first
		long millis = System.currentTimeMillis();
		long seconds = millis/1000;
		int sum = 0;
		
		// Generate random sequence
		Random rand = new Random();
		for(int i = 0; i < SEQUENCE_LENGTH; i++) {
			
			sum += rand.nextInt(SEQUENCE_BOUND);
		}
		
		// Add the number of seconds with the random sequence
		// Then extract only a portion of that sequence to ensure a limit on the sequence
		String rawSequence = "" + ((int)seconds + sum);
		for(int i = rawSequence.length() - 1; i >= 0; i--) {
			seqSb.append(rawSequence.charAt(i));
		}
		System.out.println("Random sequence portion of non-patient ID: " + 
				seqSb.subSequence(START_SEQUENCE, END_SEQUENCE).toString());
		return seqSb.subSequence(START_SEQUENCE, END_SEQUENCE).toString();
	}
	
	// index helper method
	private static String normalizeIndex(int index) {
		
		int DOUBLE_DIGITS = 10;
		if(index < DOUBLE_DIGITS) {
			return "0" + ++index; // Need to add 1 so the index remains greater than zero.
		}
		return "" + ++index;
	}
}
