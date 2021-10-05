package com.empty_works.plain_emrs.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RandomCharsUtilTest {

	@Test
	void testGetLetters() {
		
		String sequence = RandomCharsUtil.getLetters(5);
		Assertions.assertEquals(5, sequence.length());
		Assertions.assertEquals(true, Character.isAlphabetic(sequence.charAt(0)));

	}
}
