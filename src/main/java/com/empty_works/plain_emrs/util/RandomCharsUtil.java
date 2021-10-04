package com.empty_works.plain_emrs.util;

import java.util.Random;

public class RandomCharsUtil {

	private static String letters = "abcdefghijklmnopqrstuvwxyz";
	private static String nums = "0123456789";
	private static String symbols = "!$%&/()?+-:.,<>*#";
	
	final public static String getLetters(int length) {
		
		return scramble(length, letters);
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
		
		System.out.println("RandomCharUtil scramble()= " + sb.toString());
		return sb.toString();
	}
}
