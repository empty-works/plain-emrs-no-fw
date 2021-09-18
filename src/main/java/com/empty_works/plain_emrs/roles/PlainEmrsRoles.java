package com.empty_works.plain_emrs.roles;

import java.util.ArrayList;
import java.util.List;

public class PlainEmrsRoles {

	final public static List<RolePair> roleList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add(new RolePair("ROLE_ADMIN", "Admin"));
			add(new RolePair("ROLE_PATIENT", "Patient"));
			add(new RolePair("ROLE_DOCTOR", "Doctor"));
			add(new RolePair("ROLE_NURSE", "Nurse"));
			add(new RolePair("ROLE_ALLIED_MED_STAFF", "Allied Medical Staff"));
			add(new RolePair("ROLE_PROVIDER", "Provider"));
			add(new RolePair("ROLE_GOVERNMENT", "Government"));
			add(new RolePair("ROLE_UNKNOWN", "Unknown"));
		}
	};
	
	final public static RolePair invalidUser = new RolePair("INVALID_USER", "Invalid user");
}
