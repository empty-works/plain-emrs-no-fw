package com.empty_works.plain_emrs.contants;

public class PlainEmrsRole {

	final public static String adminRole = "ROLE_ADMIN";
	final public static String patientRole = "ROLE_PATIENT";
	final public static String doctorRole = "ROLE_DOCTOR";
	final public static String nurseRole = "ROLE_NURSE";
	final public static String alliedMedStaffRole = "ROLE_ALLIED_MED_STAFF";
	final public static String providerRole = "ROLE_PROVIDER";
	final public static String governmentRole = "ROLE_GOVERNMENT";
	final public static String unknownRole = "ROLE_UNKNOWN";
	
	final public static String admin = "Admin";
	final public static String patient = "Patient";
	final public static String doctor = "Doctor";
	final public static String nurse = "Nurse";
	final public static String alliedMedStaff = "Allied Medical Staff";
	final public static String provider = "Provider";
	final public static String government = "Government";
	final public static String unknown = "Unknown";
	
	public static String getRole(String roleDb) {
		
		if(roleDb.equals(adminRole)) return adminRole;
		else if(roleDb.equals(doctorRole)) return doctorRole;
		else if(roleDb.equals(nurseRole)) return nurseRole;
		else if(roleDb.equals(alliedMedStaffRole)) return alliedMedStaffRole;
		else if(roleDb.equals(providerRole)) return providerRole;
		else if(roleDb.equals(governmentRole)) return governmentRole;
		else return unknownRole;
	}
}
