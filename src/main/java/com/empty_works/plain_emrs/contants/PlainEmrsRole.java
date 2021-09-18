package com.empty_works.plain_emrs.contants;

public class PlainEmrsRole {

	final public static String admin = "ROLE_ADMIN";
	final public static String patient = "ROLE_PATIENT";
	final public static String doctor = "ROLE_DOCTOR";
	final public static String nurse = "ROLE_NURSE";
	final public static String alliedMedStaff = "ROLE_ALLIED_MED_STAFF";
	final public static String provider = "ROLE_PROVIDER";
	final public static String government = "ROLE_GOVERNMENT";
	final public static String unknown = "ROLE_UNKNOWN";
	
	
	public static String getRole(String roleDb) {
		
		if(roleDb.equals(admin)) return admin;
		else if(roleDb.equals(doctor)) return doctor;
		else if(roleDb.equals(nurse)) return nurse;
		else if(roleDb.equals(alliedMedStaff)) return alliedMedStaff;
		else if(roleDb.equals(provider)) return provider;
		else if(roleDb.equals(government)) return government;
		else return unknown;
	}
}
