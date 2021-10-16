package com.empty_works.plain_emrs.util.helpers;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateOfBirthUtilTest {

	@Test
	void testGetDobId_singleDigitDates() {
		
		// Checking if month and day are properly normalized if they are single digit
		String dobId = DateOfBirthUtil.getDobId(LocalDate.of(1999, 5, 9));
		System.out.println("DateOfBirthUtil getDobId_singleDigitDates: " + dobId);
		Assertions.assertEquals("090599", dobId);
	}
	
	@Test
	void testGetDobId_doubleDigitDates() {
		
		// Checking if month and day are properly normalized if they are double digits
		String dobId = DateOfBirthUtil.getDobId(LocalDate.of(1999, 12, 25));
		System.out.println("DateOfBirthUtil getDobId_doubleDigitDates: " + dobId);
		Assertions.assertEquals("251299", dobId);
	}
	
	@Test
	void testGetDobId_singleMonthDoubleDayDigits() {
		
		// Checking when month is single digit and day is double digit.
		String dobId = DateOfBirthUtil.getDobId(LocalDate.of(1999, 2, 14));
		System.out.println("DateOfBirthUtil getDobId_singleMonthDoubleDayDigits: " + dobId);
		Assertions.assertEquals("140299", dobId);
	}
	
	@Test
	void testGetDobId_doubleMonthSingleDayDigits() {
		
		// Checking when month is double digit and day is single digit.
		String dobId = DateOfBirthUtil.getDobId(LocalDate.of(1999, 10, 1));
		System.out.println("DateOfBirthUtil getDobId_doubleMonthSingleDayDigits: " + dobId);
		Assertions.assertEquals("011099", dobId);
	}
	
	@Test
	void testGetShortYear() {
		
		String sYear = DateOfBirthUtil.getShortYear(LocalDate.of(1999, 10, 2));
		Assertions.assertEquals("99", sYear);
	}
}
