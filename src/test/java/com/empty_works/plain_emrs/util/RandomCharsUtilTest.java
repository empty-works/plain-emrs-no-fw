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
			
			if(!Character.isLetter(sequence.charAt(i))) {
				
				isAlphabetic = false;
				break;
			}
		}
		System.out.println("RandomCharsUtil.getLetters test if all characters are alphabetic= " + sequence);
		Assertions.assertTrue(isAlphabetic);
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
		Assertions.assertTrue(isNumeric);
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
		Assertions.assertTrue(isLetterNum);
	}
	
	@Test
	void testLettersSymbols_sequenceLength() {
		
		String sequence = RandomCharsUtil.getLettersSymbols(5);
		System.out.println("RandomCharsUtil.getLettersSymbols test if length is 5 characters long= " + sequence);
		Assertions.assertEquals(5, sequence.length());
	}
	
	@Test
	void testGetLettersSymbols_containsAllLettersSymbols() {
		
		String sequence = RandomCharsUtil.getLettersSymbols(5);
		boolean isLetterSymbol = true;
		for(int i = 0; i < sequence.length(); i++) {
			
			if(Character.isDigit(sequence.charAt(i))) {
				
				isLetterSymbol = false;
				break;
			}
		}
		System.out.println("RandomCharsUtil.getLettersSymbols test if all characters are digits= " + sequence);
		Assertions.assertTrue(isLetterSymbol);
	}
	
	@Test
	void testNumsSymbols_sequenceLength() {
		
		String sequence = RandomCharsUtil.getNumsSymbols(5);
		System.out.println("RandomCharsUtil.getNumsSymbols test if length is 5 characters long= " + sequence);
		Assertions.assertEquals(5, sequence.length());
	}
	
	@Test
	void testGetNumsSymbols_containsAllNumsSymbols() {
		
		String sequence = RandomCharsUtil.getNumsSymbols(5);
		boolean isNumSymbol = true;
		for(int i = 0; i < sequence.length(); i++) {
			
			if(Character.isLetter(sequence.charAt(i))) {
				
				isNumSymbol = false;
				break;
			}
		}
		System.out.println("RandomCharsUtil.getNumsSymbols test if all characters are digits= " + sequence);
		Assertions.assertTrue(isNumSymbol);
	}
	
	@Test
	void testLettersNumsSymbols_sequenceLength() {
		
		String sequence = RandomCharsUtil.getLettersNumsSymbols(5);
		System.out.println("RandomCharsUtil.getLettersNumsSymbols test if length is 5 characters long= " + sequence);
		Assertions.assertEquals(5, sequence.length());
	}
}
