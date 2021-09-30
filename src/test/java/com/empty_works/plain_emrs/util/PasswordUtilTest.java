package com.empty_works.plain_emrs.util;

import org.junit.jupiter.api.Test;

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
}
