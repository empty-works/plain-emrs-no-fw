package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.beans.FacilityStaffSpecialtyBean;
import com.empty_works.plain_emrs.util.helpers.IdUtil;

public class FacilitySpecialtyIdUtil {

	final public static String get(FacilityStaffSpecialtyBean fssb) {
		
		String id;
		if(fssb.getDescription().equals("")) {
			
			id = IdUtil.get(fssb.getName(), "SPECIALITY_DESCRIPTION");
		}
		else {
			
			id = IdUtil.get(fssb.getName(), fssb.getDescription());
		}
		
		return id;
	}
}
