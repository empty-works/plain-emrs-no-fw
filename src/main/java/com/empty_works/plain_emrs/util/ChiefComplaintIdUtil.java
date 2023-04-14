package com.empty_works.plain_emrs.util;

public class ChiefComplaintIdUtil {

	final public static String get(String medRecord) {
		
		return "CC-" + medRecord + (int)System.currentTimeMillis();
	}
}
