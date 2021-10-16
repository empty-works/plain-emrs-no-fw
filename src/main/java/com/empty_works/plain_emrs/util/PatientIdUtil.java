package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.util.helpers.IdUtil;

public class PatientIdUtil {

	final public static String get(String...texts) {
		
		return "PEP-" + IdUtil.get(texts);
	}
}
