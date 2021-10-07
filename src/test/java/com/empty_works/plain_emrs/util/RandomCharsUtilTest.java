package com.empty_works.plain_emrs.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RandomCharsUtilTest {

	@Test
	void testGetLetters_sequenceLength() {
		
		String sequence = RandomCharsUtil.getLetters(5);
		System.out.println("RandomCharsUtil.getLetters test if length is 5 characters long= " + sequence);
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
		System.out.println("RandomCharsUtil.getLetters test if all characters are alphabetic= " + sequence);
		Assertions.assertEquals(true, isAlphabetic);
	}
	
	@Test
	void testGetNums_sequenceLength() {
		
		String sequence = RandomCharsUtil.getNums(5);
		System.out.println("RandomCharsUtil.getNums test if length is 5 characters long= " + sequence);
		Assertions.assertEquals(5, sequence.length());
	}
	
	@Test
	void testGetNums_containsAllNumbers() {
		
		String sequence = RandomCharsUtil.getNums(5);
		boolean isNumeric = true;
		for(int i = 0; i < sequence.length(); i++) {
			
			if(!Character.isDigit(sequence.charAt(i))) {
				
				isNumeric = false;
				break;
			}
		}
		System.out.println("RandomCharsUtil.getNums test if all characters are digits= " + sequence);
		Assertions.assertEquals(true, isNumeric);
	}
	
	@Test
	void testGetSymbols_sequenceLength() {
		
		String sequence = RandomCharsUtil.getSymbols(5);
		System.out.println("RandomCharsUtil.getSymbols test if length is 5 characters long= " + sequence);
		Assertions.assertEquals(5, sequence.length());
	}
	
	@Test
	void testGetSymbols_containsAllSymbols() {
		
		String sequence = RandomCharsUtil.getSymbols(5);
		boolean isSymbol = true;
		for(int i = 0; i < sequence.length(); i++) {
			
			if(Character.isLetterOrDigit(sequence.charAt(i))) {
				
				isSymbol = false;
				break;
			}
		}
		System.out.println("RandomCharsUtil.getSymbols test if all characters are digits= " + sequence);
		Assertions.assertTrue(isSymbol);
	}
	
	@Test
	void testLettersNums_sequenceLength() {
		
		String sequence = RandomCharsUtil.getLettersNums(5);
		System.out.println("RandomCharsUtil.getLettersNums test if length is 5 characters long= " + sequence);
		Assertions.assertEquals(5, sequence.length());
	}
	
	@Test
	void testGetLettersNums_containsAllLettersNums() {
		
		String sequence = RandomCharsUtil.getLettersNums(5);
		boolean isLetterNum = true;
		for(int i = 0; i < sequence.length(); i++) {
			
			if(!Character.isLetterOrDigit(sequence.charAt(i))) {
				
				isLetterNum = false;
				break;
			}
		}
		System.out.println("RandomCharsUtil.getLettersNums test if all characters are digits= " + sequence);
		Assertions.assertEquals(true, isLetterNum);
	}
}
