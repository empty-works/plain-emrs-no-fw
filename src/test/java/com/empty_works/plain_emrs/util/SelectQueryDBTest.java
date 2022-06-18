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
		
		String testMatch = "Stringdummy1Stringdummy2";
		List<QueryCondition> conditionList = new ArrayList<>();
		conditionList.add(new QueryCondition("", QueryDataType.STRING, "user_home_address=?", "userHomeAddress"));
		SelectQueryResult sqr = new SelectQueryResult();
		sqr.setConditionList(conditionList);
		SelectQueryDB sqdb = new SelectQueryDB(sqr);
		String resultMatch = sqdb.setMatches();
		System.out.println("setMatch() one string: " + resultMatch);
		Assertions.assertEquals(testMatch, resultMatch);
	}

}
