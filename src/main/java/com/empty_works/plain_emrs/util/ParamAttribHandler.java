package com.empty_works.plain_emrs.util;

import javax.servlet.http.HttpServletRequest;

public class ParamAttribHandler {
	
	public static String get(HttpServletRequest request, String text) {
		
		if(request.getParameter(text) != null) {
			
			return request.getParameter(text);
		}
		if(request.getAttribute(text) != null) {
			
			return (String) request.getAttribute(text);
		}
		
		return null;
	}
}
