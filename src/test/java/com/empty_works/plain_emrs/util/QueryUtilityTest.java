package com.empty_works.plain_emrs.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueryUtilityTest {

	@Test
	void testGet() {
		
		String query = "insert into patients("
				+ "given_name,middle_initial,last_name)"
				+ " values (?,?,?)";
		String producedQuery = QueryUtility.get("patients", "given_name", "middle_initial", "last_name");
		Assertions.assertEquals(query, producedQuery);
	}
}
