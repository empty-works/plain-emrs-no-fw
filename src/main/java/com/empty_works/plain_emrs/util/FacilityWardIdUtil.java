package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.beans.FacilityWardBean;
import com.empty_works.plain_emrs.util.helpers.IdUtil;

public class FacilityWardIdUtil {

	final public static String get(FacilityWardBean fwb) {
		
		String id = IdUtil.get(fwb.getName(), fwb.getLocation());
		System.out.println("FacilityWardIdUtil ID result= " + id);
		return "WARD-" + id;
	}
}
