package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.beans.NonPatientBean;
import com.empty_works.plain_emrs.util.helpers.PersonUtil;

public class NonPatientUsernameUtil {

	public final static String get(NonPatientBean npb) {
		
		return PersonUtil.get(npb) + "-NP";
	}
}
