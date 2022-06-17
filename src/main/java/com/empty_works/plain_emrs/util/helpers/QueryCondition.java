package com.empty_works.plain_emrs.util.helpers;

public class QueryCondition {

	public static String FIRST = "";
	public static String AND = " AND ";
	public static String OR = " OR ";
	private String operator;
	private String dataType;
	private String condition;
	private Object match;
	
	/**
	 * 
	 * @param operator
	 * @param dataType
	 * @param condition
	 * @param match
	 */
	public QueryCondition(String operator, String dataType, String condition, Object match) {
		
		this.operator = operator;
		this.dataType = dataType;
		this.condition = condition;
		this.match = match;
	}
	
	public String getCondition() {
		
		return operator + condition;
	}
	
	public Object getMatch() {
		
		return match;
	}
	
	public String getDataType() {
		
		return dataType;
	}
}
