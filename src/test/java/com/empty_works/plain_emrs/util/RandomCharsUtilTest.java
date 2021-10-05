package com.empty_works.plain_emrs.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RandomCharsUtilTest {

	@Test
	void testGetLetters_sequenceLength() {
		
		String sequence = RandomCharsUtil.getLetters(5);
		Assertions.assertEquals(5, sequence.length());
	}
	
	@Test
	void testGetLetters_containsAlphabetic() {
		
		String sequence = RandomCharsUtil.getLetters(5);
		Assertions.assertEquals(true, Character.isAlphabetic(sequence.charAt(0)));
	}
	
	@Test
	void 
}
