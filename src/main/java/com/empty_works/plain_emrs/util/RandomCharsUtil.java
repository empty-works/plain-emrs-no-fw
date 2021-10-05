package com.empty_works.plain_emrs.util;

import java.util.Random;

public class RandomCharsUtil {

	private static String letters = "abcdefghijklmnopqrstuvwxyz";
	private static String nums = "0123456789";
	private static String symbols = "!$%&/()?+-:.,<>*#";
	
	final public static String getLetters(int length) {
		
		String seq = scramble(length, letters);
		System.out.println("RandomCharsUtil.getLetters= " + seq);
		return seq;
	}
	
	final public static String getNums(int length) {
		
		String seq = scramble(length, nums);
		System.out.println("RandomCharsUtil.getNums= " + seq);
		return seq;
	}
	
	final public static String getSymbols(int length) {
		
		String seq = scramble(length, symbols);
		System.out.println("RandomCharsUtil.getSymbols= " + seq);
		return seq;
	}
	
	final public static String getLettersNums(int length) {
		
		String seq = scramble(length, letters, nums);
		System.out.println("RandomCharsUtil.getLettersNums= " + seq);
		return seq;
	}
	
	final public static String getLettersSymbols(int length) {
		
		String seq = scramble(length, letters, symbols);
		System.out.println("RandomCharsUtil.getLettersSymbols= " + seq);
		return seq;
	}

	final public static String getLettersNumsSymbols(int length) {
		
		String seq = scramble(length, letters, nums, symbols);
		System.out.println("RandomCharsUtil.getLettersNumsSymbols= " + seq);
		return seq;
	}

	final public static String getNumsSymbols(int length) {
		
		String seq = scramble(length, letters, symbols);
		System.out.println("RandomCharsUtil.getNumsSymbols= " + seq);
		return seq;
	}
	
	private static String scramble(int length, String... chars) {
		
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		StringBuilder seqSb = new StringBuilder();
		
		// Combine varargs
		for(String seq : chars) {
			
			seqSb.append(seq);
		}
		String comboSeq = seqSb.toString();
		
		for(int i = 0; i < length; i++) {
			
			sb.append(comboSeq.charAt(rand.nextInt(comboSeq.length())));
		}
		
		return sb.toString();
	}
}
