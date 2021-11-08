package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.beans.FacilityWardBean;
import com.empty_works.plain_emrs.util.helpers.IdUtil;

public class FacilityWardIdUtil {

	final public static String get(FacilityWardBean fwb) {
		
		String id;
		if(fwb.getLocation() != null) {
			
			id = IdUtil.get(fwb.getName(), fwb.getLocation());
		}
		else {
			
			id = IdUtil.get(fwb.getName(), "WARD_LOCATION");
		}
		System.out.println("FacilityWardIdUtil ID result= " + id);
		return "WARD-" + id;
	}
}
