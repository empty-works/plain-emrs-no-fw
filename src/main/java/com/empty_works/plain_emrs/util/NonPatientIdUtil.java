package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.beans.NonPatientBean;

final public class NonPatientIdUtil {

	final public static String get(NonPatientBean np) {
		
		StringBuilder id = new StringBuilder("PENP-");
		

		return id.toString();
	}
	
	private static String nameId(String givenName, String lastName) {
		
		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		
		String gnSub = (givenName.length() > 1) ? "" + givenName.charAt(0) + givenName.charAt(1) : 
			"" + givenName.charAt(0);
		
		String lnSub = (lastName.length() > 1) ? "" + lastName.charAt(0) + lastName.charAt(1) : 
			"" + lastName.charAt(0);

		int[] nameNums = new int[4];
		nameNums[0] = lowercase.indexOf(Character.toLowerCase(gnSub.charAt(0)));
		if(gnSub.length() < 1) nameNums[1] = lowercase.indexOf(Character.toLowerCase(gnSub.charAt(1)));
		nameNums[2] = lowercase.indexOf(Character.toLowerCase(lnSub.charAt(0)));
		if(lnSub.length() < 1) nameNums[3] = lowercase.indexOf(Character.toLowerCase(lnSub.charAt(1)));
	}
}
