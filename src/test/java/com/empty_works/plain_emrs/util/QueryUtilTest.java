package com.empty_works.plain_emrs.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueryUtilTest {

	@Test
	void testGet() {
		
		String query = "insert into patients("
				+ "given_name,middle_initial,last_name)"
				+ " values (?,?,?)";
		String producedQuery = QueryUtil.insert("patients", "given_name", "middle_initial", "last_name");
		System.out.println(producedQuery);
		Assertions.assertEquals(query, producedQuery);
	}
}
