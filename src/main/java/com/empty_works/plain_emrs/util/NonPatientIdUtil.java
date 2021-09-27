package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.beans.NonPatientBean;

final public class NonPatientIdUtil {

	final public static String get(NonPatientBean np) {
		
		StringBuilder idSb = new StringBuilder("PENP-");

		idSb.append(getNameId(np.getGivenName(), np.getLastName()));
		
		return idSb.toString();
	}
	
	private static String getNameId(String givenName, String lastName) {
		
		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		String gnSub = getNameSub(givenName);
		String lnSub = getNameSub(lastName);
		
		StringBuilder namesSb = new StringBuilder("");

		namesSb.append(normalizeNum(lowercase.indexOf(Character.toLowerCase(gnSub.charAt(0)))));
		if(gnSub.length() > 1) namesSb.append(lowercase.indexOf(Character.toLowerCase(gnSub.charAt(1))));
		else namesSb.append("00");
		namesSb.append(lowercase.indexOf(Character.toLowerCase(lnSub.charAt(0))));
		if(lnSub.length() > 1) namesSb.append(lowercase.indexOf(Character.toLowerCase(lnSub.charAt(1))));
		else namesSb.append("00");
		
		System.out.println("Name portion of non-patient ID: " + namesSb.toString());
		
		return namesSb.toString();
	}
	
	// getNameId helper
	private static String normalizeNum(int index) {
		
		int DOUBLE_DIGITS = 10;
		if(index < DOUBLE_DIGITS) {
			return "0" + index;
		}
		return "" + index;
	}
	
	// getNameId helper
	private static String getNameSub(String name) {
		
		return (name.length() > 1) ? "" + name.charAt(0) + name.charAt(1) : "" + name.charAt(0);
	}
}
