package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.beans.NonPatientBean;

public class UsernameUtil {

	//TODO: generate a username with only select letters from name and other stuff
	public static String get(NonPatientBean npb) {
		
		String givenName = npb.getGivenName();
		String lastName = npb.getLastName();
		StringBuilder unSb = new StringBuilder();
		
		
		return "";
	}
	
	protected static String getNameId(String givenName, String lastName) {
		

		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		
		if(givenName.length < )
		return "";
	}
	
	private static String getNameHelper(String name) {
		

		return "";
	}
}
