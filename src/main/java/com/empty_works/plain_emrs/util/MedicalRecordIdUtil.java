package com.empty_works.plain_emrs.util;

public class MedicalRecordIdUtil {

	public static String get(String userId) {
		
		// User ID with a randomly generated number between a max and min.
		return userId + Math.floor(Math.random()*(99999 - 10000 + 1) + 10000);
	}
}
