package com.empty_works.plain_emrs.util.helpers;

import java.time.LocalDate;

public class DateOfBirthUtil {

	public static String getDobId(LocalDate dob) {
		
		int day = dob.getDayOfMonth();
		int month = dob.getMonthValue();
		int year = dob.getYear();
		final int DOUBLE_DIGITS = 10;
		
		StringBuilder dobSb = new StringBuilder("");
		dobSb.append((day < DOUBLE_DIGITS ? "0" + day : "" + day).charAt(1));
		dobSb.append((month < DOUBLE_DIGITS ? "0" +  month : "" + month).charAt(1));
		dobSb.append(("" + year).substring(2));
		
		return dobSb.toString();
	}
}
