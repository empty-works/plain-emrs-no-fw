package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.util.helpers.IdUtil;

public class RoleIdUtil {

	final public static String get(String...texts) {
		
		return "ROLE-" + IdUtil.get(texts);
	}
}
