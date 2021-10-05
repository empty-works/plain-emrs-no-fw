package com.empty_works.plain_emrs.util;

import java.util.Random;
import com.empty_works.plain_emrs.beans.NonPatientBean;

public class UsernameUtil {

	final static String INVALID = "Username invalid due to invalid inputs.";

	public static String get(NonPatientBean npb) {
		
		String givenName = npb.getGivenName();
		String lastName = npb.getLastName();
		StringBuilder unSb = new StringBuilder();
		if(givenName.isEmpty() || lastName.isEmpty()) return INVALID;
		
		unSb.append(getNameId(givenName, lastName));
		
		return unSb.toString();
	}
	
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
	
	final static int SEQUENCE_LENGTH = 5;
	protected static String getRandomSequence() {
		
		return RandomCharsUtil.getNumsSymbols(SEQUENCE_LENGTH);
	}
	
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
}
