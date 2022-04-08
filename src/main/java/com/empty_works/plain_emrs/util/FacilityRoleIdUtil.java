package com.empty_works.plain_emrs.util;

public class FacilityRoleIdUtil {

	/**
	 * 
	 * @param facId
	 * @param roleId
	 * @return
	 */
	public static String get(String facId, String roleId) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(facId);
		sb.append(roleId);
		return sb.toString();
	}
}
