package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.util.helpers.IdUtil;

final public class NonPatientIdUtil {
	
	final public static String get(String...texts) {
		
		return "PENP-" + IdUtil.get(texts);
	}
}
