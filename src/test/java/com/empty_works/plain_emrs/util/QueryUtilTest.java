package com.empty_works.plain_emrs.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueryUtilTest {

	@Test
	void testInsert() {
		
		String query = "insert into patients("
				+ "given_name,middle_initial,last_name)"
				+ " values (?,?,?)";
		String producedQuery = QueryUtil.insert("patients", "given_name", "middle_initial", "last_name");
		System.out.println(producedQuery);
		Assertions.assertEquals(query, producedQuery);
	}
	
	@Test
	void testGetNoCondition() {
		
		String query = "select given_name,middle_initial,last_name from patients";
		String produceQuery = QueryUtil.getAll("patients", "given_name", "middle_initial", "last_name");
		System.out.println(produceQuery);
		Assertions.assertEquals(query, produceQuery);
	}
	
	@Test
	void testGetWithCondition() {
		
		String query = "select given_name,middle_initial,last_name from patients where patient_id=?";
		String produceQuery = QueryUtil.getCondition("patients", "patient_id", "given_name", "middle_initial", "last_name");
		System.out.println(produceQuery);
		Assertions.assertEquals(query, produceQuery);
	}
}
