package com.empty_works.plain_emrs.util;

import java.time.LocalDate;

import com.empty_works.plain_emrs.beans.NonPatientBean;

final public class NonPatientIdUtil {
	
	final public static String INVALID = "Invalid inputs";

	final public static String get(NonPatientBean np) {
		
		StringBuilder idSb = new StringBuilder("PENP-");

		String nameId = getNameId(np.getGivenName(), np.getLastName());
		if(nameId.equals(INVALID)) return INVALID;
		idSb.append(nameId);
		idSb.append(getDobId(np.getDateOfBirth()));
		idSb.append("-" + System.currentTimeMillis());
		
		System.out.println("Final non-patient ID: " + idSb.toString());
		return idSb.toString();
	}
	
	protected static String getNameId(String givenName, String lastName) {
		
		// Should not be necessary, but will check for empty strings
		if(givenName.isEmpty() || lastName.isEmpty()) return INVALID;

		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		String gnSub = getNameSub(givenName);
		String lnSub = getNameSub(lastName);
		StringBuilder namesSb = new StringBuilder("");
		
		namesSb.append(normalizeNum(lowercase.indexOf(Character.toLowerCase(gnSub.charAt(0)))));
		if(gnSub.length() > 1) namesSb.append(normalizeNum(lowercase.indexOf(Character.toLowerCase(gnSub.charAt(1)))));
		else namesSb.append("00");
		namesSb.append(normalizeNum(lowercase.indexOf(Character.toLowerCase(lnSub.charAt(0)))));
		if(lnSub.length() > 1) namesSb.append(normalizeNum(lowercase.indexOf(Character.toLowerCase(lnSub.charAt(1)))));
		else namesSb.append("00");
		
		System.out.println("Name portion of non-patient ID: " + namesSb.toString());
		
		return namesSb.toString();
	}
	
	protected static String getDobId(LocalDate dob) {
		
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
	
	// getNameId helper
	private static String normalizeNum(int index) {
		
		int DOUBLE_DIGITS = 10;
		if(index < DOUBLE_DIGITS) {
			return "0" + ++index; // Need to add 1 so the index remains greater than zero.
		}
		return "" + ++index;
	}
	
	// getNameId helper
	private static String getNameSub(String name) {
		
		return (name.length() > 1) ? "" + name.charAt(0) + name.charAt(1) : "" + name.charAt(0);
	}
}
