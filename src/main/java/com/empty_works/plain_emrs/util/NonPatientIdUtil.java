package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.beans.NonPatientBean;
import com.empty_works.plain_emrs.util.helpers.IdUtil;

final public class NonPatientIdUtil {
	
	final public static String get(NonPatientBean np) {
		
		return "PENP-" + IdUtil.get(np);
	}
}
