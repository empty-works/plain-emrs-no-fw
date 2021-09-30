package com.empty_works.plain_emrs.util;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;

public class PasswordUtilTest {

	@Test
	void testGetNameId_singleDigitIndex() {
		
		// The indices of the first two characters of each name are less than 10.
		String nameId = NonPatientIdUtil.getNameId("Fatima", "Garcia");
		Assertions.assertEquals("06010701", nameId);
	}
	
	@Test
	void testGetNameId_doubleDigitIndex() {
		
		// The indices of the first two characters of each name are equal to or greater than 10.
		String nameId = NonPatientIdUtil.getNameId("Monique", "Rooney");
		Assertions.assertEquals("13151815", nameId);
	}
	
	@Test
	void testGetNameId_singleLetterNames() {
		
		// Names only have one letter
		String nameId = NonPatientIdUtil.getNameId("Q", "B");
		Assertions.assertEquals("17000200", nameId);
	}
	
	@Test
	void testGetNameId_emptyStringBothNames() {
		
		// Should be checked for in the interface layer but included just in case.
		String nameId = NonPatientIdUtil.getNameId("", "");
		Assertions.assertEquals(NonPatientIdUtil.INVALID, nameId);
	}
	
	@Test
	void testGetNameId_emptyStringGivenName() {
		
		// Should be checked for in the interface layer but still checks if first name is empty.
		String nameId = NonPatientIdUtil.getNameId("", "Helioport");
		Assertions.assertEquals(NonPatientIdUtil.INVALID, nameId);
	}
	
	@Test
	void testGetNameId_emptyStringLastName() {
		
		// Should be checked for in the interface layer but still checks if last name is empty.
		String nameId = NonPatientIdUtil.getNameId("Allison", "");
		Assertions.assertEquals(NonPatientIdUtil.INVALID, nameId);
	}
	
	@Test
	void testGetDobId_singleDigitDates() {
		
		// Checking if month and day are properly normalized if they are single digit
		String dobId = NonPatientIdUtil.getDobId(LocalDate.of(1999, 5, 9));
		Assertions.assertEquals("09051999", dobId);
	}
	
	@Test
	void testGetDobId_doubleDigitDates() {
		
		// Checking if month and day are properly normalized if they are double digits
		String dobId = NonPatientIdUtil.getDobId(LocalDate.of(1999, 12, 25));
		Assertions.assertEquals("25121999", dobId);
	}
	
	@Test
	void testGetDobId_singleMonthDoubleDayDigits() {
		
		// Checking when month is single digit and day is double digit.
		String dobId = NonPatientIdUtil.getDobId(LocalDate.of(1999, 2, 14));
		Assertions.assertEquals("14021999", dobId);
	}
	
	@Test
	void testGetDobId_doubleMonthSingleDayDigits() {
		
		// Checking when month is double digit and day is single digit.
		String dobId = NonPatientIdUtil.getDobId(LocalDate.of(1999, 10, 1));
		Assertions.assertEquals("01101999", dobId);
	}
}
