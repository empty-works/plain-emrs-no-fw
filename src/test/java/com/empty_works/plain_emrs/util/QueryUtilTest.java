package com.empty_works.plain_emrs.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.empty_works.plain_emrs.util.helpers.QueryCondition;
import com.empty_works.plain_emrs.util.helpers.QueryDataType;
import com.empty_works.plain_emrs.util.helpers.QueryField;
import com.empty_works.plain_emrs.util.helpers.QueryJoin;

class QueryUtilTest {

	@Test
	void testSelectNoJoinNoConditions() {
		
		String testQuery = "SELECT user_name,user_home_address,user_email_address FROM users";
		QueryUtil qu = new QueryUtil(""); // Dummy constructor
		qu.addField(new QueryField(QueryDataType.STRING, "user_name"));
		qu.addField(new QueryField(QueryDataType.STRING, "user_home_address"));
		qu.addField(new QueryField(QueryDataType.STRING, "user_email_address"));
		qu.setTable("users");
		String finalQuery = qu.select();
		System.out.println("Select final query: " + finalQuery);
		Assertions.assertEquals(testQuery, finalQuery);
	}
	
	@Test
	void testSelectWithJoin() {
		
		String testQuery = "SELECT user_name,user_home_address,user_email_address FROM users JOIN authorities ON users.user_name=authorities.user_name";
		QueryUtil qu = new QueryUtil(""); // Dummy constructor
		qu.addField(new QueryField(QueryDataType.STRING, "user_name"));
		qu.addField(new QueryField(QueryDataType.STRING, "user_home_address"));
		qu.addField(new QueryField(QueryDataType.STRING, "user_email_address"));
		qu.setTable("users");
		qu.setJoin(new QueryJoin(QueryJoin.JOIN, "authorities", "users.user_name=authorities.user_name"));
		String finalQuery = qu.select();
		System.out.println("Select final query with join: " + finalQuery);
		Assertions.assertEquals(testQuery, finalQuery);
	}
	
	@Test
	void testSelectWithOneCondition() {
		
		String testQuery = "SELECT user_home_address,user_email_address FROM users WHERE user_name=?";
		QueryUtil qu = new QueryUtil(""); // Dummy constructor
		qu.addField(new QueryField(QueryDataType.STRING, "user_home_address"));
		qu.addField(new QueryField(QueryDataType.STRING, "user_email_address"));
		qu.setTable("users");
		qu.addCondition(new QueryCondition(QueryCondition.FIRST, QueryDataType.STRING, "user_name=?", "dummy"));
		String finalQuery = qu.select();
		System.out.println("Select final query with a condition: " + finalQuery);
		Assertions.assertEquals(testQuery, finalQuery);
	}
	
	@Test
	void testSelectWithConditions() {
		
		String testQuery = "SELECT user_name,user_home_address,user_email_address FROM users WHERE user_home_address=? AND user_email_address=?";
		QueryUtil qu = new QueryUtil(""); // Dummy constructor
		qu.addField(new QueryField(QueryDataType.STRING, "user_name"));
		qu.addField(new QueryField(QueryDataType.STRING, "user_home_address"));
		qu.addField(new QueryField(QueryDataType.STRING, "user_email_address"));
		qu.setTable("users");
		qu.addCondition(new QueryCondition(QueryCondition.FIRST, QueryDataType.STRING, "user_home_address=?", "dummy1"));
		qu.addCondition(new QueryCondition(QueryCondition.AND, QueryDataType.STRING, "user_email_address=?", "dummy2"));
		String finalQuery = qu.select();
		System.out.println("Select final query with conditions: " + finalQuery);
		Assertions.assertEquals(testQuery, finalQuery);
	}
	
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
		String produceQuery = QueryUtil.selectAll("patients", "given_name", "middle_initial", "last_name");
		System.out.println(produceQuery);
		Assertions.assertEquals(query, produceQuery);
	}
	
	@Test
	void testGetWithCondition() {
		
		String query = "select given_name,middle_initial,last_name from patients where patient_id=?";
		String produceQuery = QueryUtil.selectWithCondition("patients", "patient_id", "given_name", "middle_initial", "last_name");
		System.out.println(produceQuery);
		Assertions.assertEquals(query, produceQuery);
	}
	
	@Test
	void testGetAll() {
		
		String query = "select given_name,middle_initial,last_name from patients";
		String produceQuery = QueryUtil.selectAll("patients", "given_name", "middle_initial", "last_name");
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
