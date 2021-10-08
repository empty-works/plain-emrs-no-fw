package com.empty_works.plain_emrs.util;

import java.time.LocalDate;
import java.util.Random;

import com.empty_works.plain_emrs.beans.NonPatientBean;
import com.empty_works.plain_emrs.util.helpers.RandomCharsUtil;

public class UsernameUtil {

	final static String INVALID = "Username invalid due to invalid inputs.";

	public static String get(NonPatientBean npb) {
		
		String givenName = npb.getGivenName();
		String lastName = npb.getLastName();
		StringBuilder unSb = new StringBuilder();
		if(givenName.isEmpty() || lastName.isEmpty()) return INVALID;
		
		unSb.append(getNameId(givenName, lastName));
		unSb.append(getDobId(npb.getDateOfBirth()));
		unSb.append(getRandomSequence());
		
		return unSb.toString();
	}
	
	// Protected for unit test
	protected static String getNameId(String givenName, String lastName) {
		
		final int NAME_PART_LENGTH = 4;
		StringBuilder nSb = new StringBuilder();
		
		nSb.append(givenName.length() >= NAME_PART_LENGTH ? 
				givenName.substring(0, NAME_PART_LENGTH).toLowerCase() : 
					fillName(givenName, NAME_PART_LENGTH));
		
		nSb.append(lastName.length() >= NAME_PART_LENGTH ? 
				lastName.substring(0, NAME_PART_LENGTH).toLowerCase() : 
					fillName(lastName, NAME_PART_LENGTH));

		System.out.println("Username generator name portion: " + nSb.toString());
		return nSb.toString(); 
	}

	// getNameId helper
	private static String fillName(String name, int namePartLength) {
		
		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder nSb = new StringBuilder();
		
		Random rand = new Random();
		int fillNum = namePartLength - name.length();
		nSb.append(name.toLowerCase());
		for(int i = 0; i < fillNum; i++) {
			
			nSb.append(lowercase.charAt(rand.nextInt(lowercase.length())));
		}
		
		return nSb.toString();
	}
	
	private static String getDobId(LocalDate dob) {
		
		int day = dob.getDayOfMonth();
		int month = dob.getMonthValue();
		int year = dob.getYear();
		final int DOUBLE_DIGITS = 10;
		
		StringBuilder dobSb = new StringBuilder("");
		dobSb.append(day < DOUBLE_DIGITS ? "0" + day : "" + day);
		dobSb.append(month < DOUBLE_DIGITS ? "0" +  month : "" + month);
		dobSb.append("" + year);
		
		System.out.println("DOB portion of non-patient ID: " + dobSb.toString());
		return dobSb.toString();
	}
	
	final static int SEQUENCE_LENGTH = 5;
	private static String getRandomSequence() {
		
		return "_" + RandomCharsUtil.getNumsSymbols(SEQUENCE_LENGTH);
	}
}
