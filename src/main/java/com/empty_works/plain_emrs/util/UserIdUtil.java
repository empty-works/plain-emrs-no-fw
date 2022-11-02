package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.util.helpers.IdUtil;

public class UserIdUtil {

	public static String PATIENT = "patient";
	public static String NON_PATIENT = "nonpatient";

	final public static String get(String userType, String...texts) {
		
		if(userType.equals(PATIENT)) {
			return "PU-" + IdUtil.get(texts);
		}
		else {
			return "NPU-" + IdUtil.get(texts); 
		}
	}
}
