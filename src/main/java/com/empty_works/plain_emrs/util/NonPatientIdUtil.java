package com.empty_works.plain_emrs.util;

import java.time.LocalDate;
import java.util.Random;
import com.empty_works.plain_emrs.beans.NonPatientBean;
import com.empty_works.plain_emrs.util.helpers.DateOfBirthUtil;

final public class NonPatientIdUtil {
	
	//TODO: Make this class a superclass with nonpatient and patient children
	final public static String INVALID = "Invalid ID due to invalid inputs.";

	final public static String get(NonPatientBean np) {
		
		StringBuilder idSb = new StringBuilder("PENP-");

		if(np.getGivenName().isEmpty() || np.getLastName().isEmpty()) return INVALID;
		//String nameId = getNameId(np.getGivenName(), np.getLastName());
		String nameId = UsernameUtil.get(np);
		idSb.append(nameId);
		idSb.append(getDobId(np.getDateOfBirth()));
		idSb.append(getRandomSequence());
		
		System.out.println("Final non-patient ID: " + idSb.toString());
		return idSb.toString();
	}
	
	protected static String getNameId(String givenName, String lastName) {
		
		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		String gnSub = getNameSub(givenName);
		String lnSub = getNameSub(lastName);
		StringBuilder namesSb = new StringBuilder("");
		
		namesSb.append(normalizeIndex(lowercase.indexOf(Character.toLowerCase(gnSub.charAt(0)))));
		if(gnSub.length() > 1) namesSb.append(normalizeIndex(lowercase.indexOf(Character.toLowerCase(gnSub.charAt(1)))));
		else namesSb.append("00");
		namesSb.append(normalizeIndex(lowercase.indexOf(Character.toLowerCase(lnSub.charAt(0)))));
		if(lnSub.length() > 1) namesSb.append(normalizeIndex(lowercase.indexOf(Character.toLowerCase(lnSub.charAt(1)))));
		else namesSb.append("00");
		
		System.out.println("Name portion of non-patient ID: " + namesSb.toString());
		
		return namesSb.toString();
	}

	// getNameId helper
	private static String getNameSub(String name) {
		
		return (name.length() > 1) ? "" + name.charAt(0) + name.charAt(1) : "" + name.charAt(0);
	}
	
	protected static String getDobId(LocalDate dob) {
		
		return DateOfBirthUtil.getDobId(dob);
	}
	
	public final static int SEQUENCE_LENGTH = 6;
	protected static String getRandomSequence() {
		
		final int SEQUENCE_BOUND = 1000;
		final int START_SEQUENCE = 1;
		final int END_SEQUENCE = 7;
		StringBuilder seqSb = new StringBuilder();

		// Calculate seconds first
		long millis = System.currentTimeMillis();
		long seconds = millis/1000;
		long sum = 0;
		
		// Generate random sequence
		Random rand = new Random();
		for(int i = 0; i < SEQUENCE_LENGTH; i++) {
			
			sum += rand.nextInt(SEQUENCE_BOUND);
		}
		
		// Add the number of seconds with the random sequence
		// Then extract only a portion of that sequence to ensure a limit on the sequence
		String rawSequence = "" + (seconds + sum);
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
