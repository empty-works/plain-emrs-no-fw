package com.empty_works.plain_emrs.util.helpers;

import java.time.LocalDate;
import java.util.Random;

import com.empty_works.plain_emrs.beans.PersonBean;
import com.empty_works.plain_emrs.beans.UserBean;

public class PersonUtil {

	final static String INVALID = "Username invalid due to invalid inputs.";

	public static String get(PersonBean person) {
		
		String givenName = person.getGivenName();
		String lastName = person.getLastName();
		StringBuilder unSb = new StringBuilder();
		if(givenName.isEmpty() || lastName.isEmpty()) return INVALID;
		
		unSb.append(getName(givenName, lastName));
		unSb.append(getDob(person.getDateOfBirth()));
		unSb.append("_" + getRandomSequence());
		
		return unSb.toString();
	}
	
	public static String get(UserBean user) {
		
		
		return "";
	}
	
	// Protected for unit test
	protected static String getName(String givenName, String lastName) {
		
		final int NAME_PART_LENGTH = 2;
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
	
	private static String getDob(LocalDate dob) {
		
		return DateOfBirthUtil.getDobId(dob);
	}
	
	final static int SEQUENCE_LENGTH = 4;
	private static String getRandomSequence() {
		
		return RandomCharsUtil.getLettersNums(SEQUENCE_LENGTH);
	}
}
