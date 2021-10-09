package com.empty_works.plain_emrs.util.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomCharsUtil {

	private static String letters = "abcdefghijklmnopqrstuvwxyz";
	private static String nums = "0123456789";
	private static String symbols = "!$%&/()?+:.,<>*#";
	
	final public static String getLetters(int length) {
		
		String seq = scramble(length, letters);
		return seq;
	}
	
	final public static String getNums(int length) {
		
		String seq = scramble(length, nums);
		return seq;
	}
	
	final public static String getSymbols(int length) {
		
		String seq = scramble(length, symbols);
		return seq;
	}
	
	final public static String getLettersNums(int length) {
		
		String seq = scramble(length, letters, nums);
		return seq;
	}
	
	final public static String getLettersSymbols(int length) {
		
		String seq = scramble(length, letters, symbols);
		return seq;
	}

	final public static String getNumsSymbols(int length) {
		
		String seq = scramble(length, nums, symbols);
		return seq;
	}

	final public static String getLettersNumsSymbols(int length) {
		
		String seq = scramble(length, letters, nums, symbols);
		return seq;
	}

	private static String scramble(int length, String... chars) {
		
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		
		String comboSeq = shuffleSeqs(chars);
		
		for(int i = 0; i < length; i++) {
			
			sb.append(comboSeq.charAt(rand.nextInt(comboSeq.length())));
		}
		
		return sb.toString();
	}
	
	private static String shuffleSeqs(String...strings) {
		
		List<Integer> indexList = new ArrayList<>();
		String sequence = "";
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();

		for(String seq : strings) {
			
			sequence += seq;
		}

		for(int i = 0; i < sequence.length(); i++) {
			
			indexList.add(rand.nextInt(sequence.length()));
			sb.append(sequence.charAt(indexList.get(i)));
		}

		System.out.println("RandomCharsUtil shuffleSeqs() result= " + sb.toString());
		return sb.toString();
	}
}
