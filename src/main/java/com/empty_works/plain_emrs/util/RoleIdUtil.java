package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.beans.RoleBean;
import com.empty_works.plain_emrs.util.helpers.IdUtil;

public class RoleIdUtil {

	final public static String get(RoleBean rb) {
		
		String id;
		if(rb.getGroup().equals("")) {
			
			id = IdUtil.get(rb.getName(), "ROLE_GROUP");
		}
		else {
			
			id = IdUtil.get(rb.getName(), rb.getGroup());
		}
		
		return "ROLE-" + id;
	}
	
	final public static String get(String facId, String roleName) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(facId);
		sb.append(roleName);
		return sb.toString();
	}
}
