package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.beans.FacilityWardBean;
import com.empty_works.plain_emrs.util.helpers.IdUtil;

public class FacilityWardIdUtil {

	final public static String get(FacilityWardBean fwb) {
		
		String id;
		if(fwb.getLocation().equals("")) {
			
			id = IdUtil.get(fwb.getName(), "WARD_LOCATION");
		}
		else {
			
			id = IdUtil.get(fwb.getName(), fwb.getLocation());
		}
		return "WARD-" + id;
	}
}
