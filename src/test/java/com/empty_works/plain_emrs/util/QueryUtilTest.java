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
		String producedQuery = QueryUtil.add("patients", "given_name", "middle_initial", "last_name");
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
		String produceQuery = QueryUtil.getWithCondition("patients", "patient_id", "given_name", "middle_initial", "last_name");
		System.out.println(produceQuery);
		Assertions.assertEquals(query, produceQuery);
	}
	
	@Test
	void testGetAll() {
		
		String query = "select given_name,middle_initial,last_name from patients";
		String produceQuery = QueryUtil.getAll("patients", "given_name", "middle_initial", "last_name");
		System.out.println(produceQuery);
		Assertions.assertEquals(query, produceQuery);
	}
	
	@Test
	void testUpdateWithCondition() {
		
		String query = "update patients set given_name=?,middle_initial=?,last_name=? where patient_id=?";
		String produceQuery = QueryUtil.updateWithCondition("patients", "patient_id", "given_name", "middle_initial", "last_name");
		System.out.println(produceQuery);
		Assertions.assertEquals(query, produceQuery);
	}
	
	@Test
	void testUpdateAll() {
		
		String query = "update patients set given_name=?,middle_initial=?,last_name=?";
		String produceQuery = QueryUtil.updateAll("patients", "given_name", "middle_initial", "last_name");
		System.out.println(produceQuery);
		Assertions.assertEquals(query, produceQuery);
	}
}
