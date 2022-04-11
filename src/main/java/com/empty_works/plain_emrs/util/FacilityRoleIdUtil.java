package com.empty_works.plain_emrs.util;

public class FacilityRoleIdUtil {

	/**
	 * 
	 * @param facId
	 * @param roleName
	 * @return
	 */
	public static String get(String facId, String roleName) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(facId);
		sb.append(roleName);
		return sb.toString();
	}
}
