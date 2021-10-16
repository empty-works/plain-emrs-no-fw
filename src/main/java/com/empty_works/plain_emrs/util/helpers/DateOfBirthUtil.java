package com.empty_works.plain_emrs.util.helpers;

import java.time.LocalDate;

public class DateOfBirthUtil {

	public static String getDobId(LocalDate dob) {
		
		int day = dob.getDayOfMonth();
		int month = dob.getMonthValue();
		int year = dob.getYear();
		final int DOUBLE_DIGITS = 10;
		
		StringBuilder dobSb = new StringBuilder("");
		dobSb.append((day < DOUBLE_DIGITS ? "0" + day : "" + day));
		dobSb.append((month < DOUBLE_DIGITS ? "0" +  month : "" + month));
		dobSb.append(("" + year).substring(2));
		
		return dobSb.toString();
	}
	
	public static String getShortYear(LocalDate dob) {
		
		int year = dob.getYear();
		String justYear = "" + year;
		// Return short form of year, i.e. - 1999 becomes 99.
		return "" + justYear.charAt(justYear.length() - 2) + justYear.charAt(justYear.length() - 1);
	}
}
