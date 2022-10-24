package com.empty_works.plain_emrs.roles;

import java.util.ArrayList;
import java.util.List;

public class PlainEmrsRoles {

	public static RolePair ROLE_ADMIN = new RolePair("ROLE_ADMIN", "Admin");
	public static RolePair ROLE_PATIENT = new RolePair("ROLE_PATIENT", "Patient");
	public static RolePair ROLE_DOCTOR = new RolePair("ROLE_DOCTOR", "Doctor");
	public static RolePair ROLE_NURSE = new RolePair("ROLE_NURSE", "Nurse");
	public static RolePair ROLE_ALLIED_MED_STAFF = new RolePair("ROLE_ALLIED_MED_STAFF", "Allied Medical Staff");
	public static RolePair ROLE_PROVIDER = new RolePair("ROLE_PROVIDER", "Provider");
	public static RolePair ROLE_GOVERNMENT = new RolePair("ROLE_GOVERNMENT", "Government");
	public static RolePair ROLE_UNKNOWN = new RolePair("ROLE_UNKNOWN", "Unknown");

	final public static List<RolePair> roleList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add(ROLE_ADMIN);
			add(ROLE_PATIENT);
			add(ROLE_DOCTOR);
			add(ROLE_NURSE);
			add(ROLE_ALLIED_MED_STAFF);
			add(ROLE_PROVIDER);
			add(ROLE_GOVERNMENT);
			add(ROLE_UNKNOWN);
		}
	};
	
	final public static RolePair invalidUser = new RolePair("INVALID_USER", "Invalid user");
}
