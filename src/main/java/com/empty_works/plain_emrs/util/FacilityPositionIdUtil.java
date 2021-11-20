package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.beans.FacilityStaffPositionBean;
import com.empty_works.plain_emrs.util.helpers.IdUtil;

public class FacilityPositionIdUtil {

	final public static String get(FacilityStaffPositionBean fspb) {
		
		String id;
		if(fspb.getDescription() == "") {
			
			id = IdUtil.get(fspb.getName(), "POSITION_DESCRIPTION");
		}
		else {
			
			id = IdUtil.get(fspb.getName(), fspb.getDescription());
		}
		return "POSITION-" + id;
	}
}
