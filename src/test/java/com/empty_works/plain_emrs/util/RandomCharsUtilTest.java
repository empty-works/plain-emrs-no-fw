package com.empty_works.plain_emrs.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RandomCharsUtilTest {

	@Test
	void testGetLetters_sequenceLength() {
		
		String sequence = RandomCharsUtil.getLetters(5);
		System.out.println("Test if length is 5 characters long= " + sequence);
		Assertions.assertEquals(5, sequence.length());
	}
	
	@Test
	void testGetLetters_containsAllAlphabetic() {
		
		String sequence = RandomCharsUtil.getLetters(5);
		boolean isAlphabetic = true;
		for(int i = 0; i < sequence.length(); i++) {
			
			if(!Character.isAlphabetic(sequence.charAt(i))) {
				
				isAlphabetic = false;
				break;
			}
		}
		System.out.println("Test if all characters are alphabetic= " + sequence);
		Assertions.assertEquals(true, isAlphabetic);
	}
	
	
}
