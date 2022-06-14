package com.empty_works.plain_emrs.util.helpers;

public class QueryCondition {

	public static String FIRST = "";
	public static String AND = " AND ";
	public static String OR = " OR ";
	private String operator;
	private String condition;
	
	/**
	 * 
	 * @param operator
	 * @param condition
	 */
	public QueryCondition(String operator, String condition) {
		
		this.operator = operator;
		this.condition = condition;
	}
	
	public String getCondition() {
		
		return operator + condition;
	}
}
