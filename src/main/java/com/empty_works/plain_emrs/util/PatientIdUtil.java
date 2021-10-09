package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.beans.PatientBean;
import com.empty_works.plain_emrs.util.helpers.IdUtil;

public class PatientIdUtil {

	final public static String get(PatientBean pb) {
		
		return "PEP-" + IdUtil.get(pb);
	}
}
