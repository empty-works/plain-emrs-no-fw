package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.beans.FacilityBean;
import com.empty_works.plain_emrs.util.helpers.IdUtil;

public class FacilityIdUtil {

	final public static String get(FacilityBean fb) {
		
		String id = IdUtil.get(fb.getName(), fb.getCity(), fb.getCountry());
		System.out.println("FacilityIdUtil ID result= " + id);
		return "PEF" + id;
	}
}
