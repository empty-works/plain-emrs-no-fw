package com.empty_works.plain_emrs.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.empty_works.plain_emrs.util.helpers.QueryCondition;
import com.empty_works.plain_emrs.util.helpers.QueryDataType;
import com.empty_works.plain_emrs.util.helpers.SelectQueryResult;

class SelectQueryDBTest {

	@Test
	void testSetMatchesOneString() {
		
		String testMatch = "StringuserHomeAddress";
		List<QueryCondition> conditionList = new ArrayList<>();
		conditionList.add(new QueryCondition("", QueryDataType.STRING, "user_home_address=?", "userHomeAddress"));
		SelectQueryResult sqr = new SelectQueryResult();
		sqr.setConditionList(conditionList);
		SelectQueryDB sqdb = new SelectQueryDB(sqr);
		String resultMatch = sqdb.setMatchesTest();
		System.out.println("setMatch() one string: " + resultMatch);
		Assertions.assertEquals(testMatch, resultMatch);
	}
	
	@Test
	void testSetMatchesTwoStrings() {
		
		String testMatch = "StringuserHomeAddressStringuserEmailAddress";
		List<QueryCondition> conditionList = new ArrayList<>();
		conditionList.add(new QueryCondition("", QueryDataType.STRING, "user_home_address=?", "userHomeAddress"));
		conditionList.add(new QueryCondition("", QueryDataType.STRING, "user_email_address=?", "userEmailAddress"));
		SelectQueryResult sqr = new SelectQueryResult();
		sqr.setConditionList(conditionList);
		SelectQueryDB sqdb = new SelectQueryDB(sqr);
		String resultMatch = sqdb.setMatchesTest();
		System.out.println("setMatch() one string: " + resultMatch);
		Assertions.assertEquals(testMatch, resultMatch);
	}
	
	@Test
	void testSetMatchesOneInt() {
		
		String testMatch = "intage";
		List<QueryCondition> conditionList = new ArrayList<>();
		conditionList.add(new QueryCondition("", QueryDataType.INT, "age=?", "age"));
		SelectQueryResult sqr = new SelectQueryResult();
		sqr.setConditionList(conditionList);
		SelectQueryDB sqdb = new SelectQueryDB(sqr);
		String resultMatch = sqdb.setMatchesTest();
		System.out.println("setMatch() one int: " + resultMatch);
		Assertions.assertEquals(testMatch, resultMatch);
	}

	@Test
	void testSetMatchesTwoInts() {
		
		String testMatch = "intageintroomNumber";
		List<QueryCondition> conditionList = new ArrayList<>();
		conditionList.add(new QueryCondition("", QueryDataType.INT, "age=?", "age"));
		conditionList.add(new QueryCondition("", QueryDataType.INT, "room_number=?", "roomNumber"));
		SelectQueryResult sqr = new SelectQueryResult();
		sqr.setConditionList(conditionList);
		SelectQueryDB sqdb = new SelectQueryDB(sqr);
		String resultMatch = sqdb.setMatchesTest();
		System.out.println("setMatch() two ints: " + resultMatch);
		Assertions.assertEquals(testMatch, resultMatch);
	}

	@Test
	void testSetMatchesOneStringOneInt() {
		
		String testMatch = "StringuserHomeAddressintage";
		List<QueryCondition> conditionList = new ArrayList<>();
		conditionList.add(new QueryCondition("", QueryDataType.STRING, "user_home_address=?", "userHomeAddress"));
		conditionList.add(new QueryCondition("", QueryDataType.INT, "age=?", "age"));
		SelectQueryResult sqr = new SelectQueryResult();
		sqr.setConditionList(conditionList);
		SelectQueryDB sqdb = new SelectQueryDB(sqr);
		String resultMatch = sqdb.setMatchesTest();
		System.out.println("setMatch() one int one String: " + resultMatch);
		Assertions.assertEquals(testMatch, resultMatch);
	}
}
