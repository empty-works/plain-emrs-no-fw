package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.beans.PatientBean;
import com.empty_works.plain_emrs.util.helpers.UsernameUtil;

public class PatientUsernameUtil {

	public final static String get(PatientBean pb) {
		
		return UsernameUtil.get(pb);
	}
}
