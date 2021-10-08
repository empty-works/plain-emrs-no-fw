package com.empty_works.plain_emrs.util;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateOfBirthUtilTest {

	@Test
	void testGetDobId_singleDigitDates() {
		
		// Checking if month and day are properly normalized if they are single digit
		String dobId = NonPatientIdUtil.getDobId(LocalDate.of(1999, 5, 9));
		System.out.println("DateOfBirthUtil getDobId_singleDigitDates: " + dobId);
		Assertions.assertEquals("09051999", dobId);
	}
	
	@Test
	void testGetDobId_doubleDigitDates() {
		
		// Checking if month and day are properly normalized if they are double digits
		String dobId = NonPatientIdUtil.getDobId(LocalDate.of(1999, 12, 25));
		System.out.println("DateOfBirthUtil getDobId_doubleDigitDates: " + dobId);
		Assertions.assertEquals("25121999", dobId);
	}
	
	@Test
	void testGetDobId_singleMonthDoubleDayDigits() {
		
		// Checking when month is single digit and day is double digit.
		String dobId = NonPatientIdUtil.getDobId(LocalDate.of(1999, 2, 14));
		System.out.println("DateOfBirthUtil getDobId_singleMonthDoubleDayDigits: " + dobId);
		Assertions.assertEquals("14021999", dobId);
	}
	
	@Test
	void testGetDobId_doubleMonthSingleDayDigits() {
		
		// Checking when month is double digit and day is single digit.
		String dobId = NonPatientIdUtil.getDobId(LocalDate.of(1999, 10, 1));
		System.out.println("DateOfBirthUtil getDobId_doubleMonthSingleDayDigits: " + dobId);
		Assertions.assertEquals("01101999", dobId);
	}
}
