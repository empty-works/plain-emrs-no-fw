package com.empty_works.plain_emrs.controllers;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

public class AddUserServletTest {

	@Test
	void testParseRaces_asianlatino() {
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		
		String[] raceArray = {"Asian", "Hispanic or Latino"};
		when(request.getParameterValues("raceCheck")).thenReturn(raceArray);
		when(request.getParameter("asianEthnDropdown")).thenReturn("Okinawan");
		when(request.getParameter("hisLatinEthnDropdown")).thenReturn("Nicaraguan");
		
		List<String> expected = new ArrayList<>() {
			
			{
				add("Asian-Okinawan");
				add("Hispanic or Latino-Nicaraguan");
			}
		};
		
		List<String> result = AddUserServlet.parseRaces(request);
		System.out.println(result);
		assertIterableEquals(expected, result);
	}
}
