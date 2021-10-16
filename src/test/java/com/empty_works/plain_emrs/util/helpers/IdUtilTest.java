package com.empty_works.plain_emrs.util.helpers;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class IdUtilTest {

	@Test
	void testGetNameId_singleDigitIndex() {
		
		// The indices of the first two characters of each name are less than 10.
		String nameId = IdUtil.getFirstPartId("Fatima", "Garcia");
		Assertions.assertEquals("06010701", nameId);
	}
	
	@Test
	void testGetNameId_doubleDigitIndex() {
		
		// The indices of the first two characters of each name are equal to or greater than 10.
		String nameId = IdUtil.getFirstPartId("Monique", "Rooney");
		Assertions.assertEquals("13151815", nameId);
	}
	
	@Test
	void testGetNameId_singleLetterNames() {
		
		// Names only have one letter
		String nameId = IdUtil.getFirstPartId("Q", "B");
		Assertions.assertEquals("17000200", nameId);
	}
	
	@Test
	void testGetRandomSequence() {
		
		// Only checks for the length of the returned sequence
		String seqId = IdUtil.getRandomSequence();
		Assertions.assertEquals(IdUtil.SEQUENCE_LENGTH, seqId.length());
	}
}
