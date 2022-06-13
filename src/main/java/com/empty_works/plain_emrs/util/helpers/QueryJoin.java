package com.empty_works.plain_emrs.util.helpers;

public class QueryJoin {

	public static String JOIN = " JOIN ";
	public static String LEFT_JOIN = " LEFT JOIN ";
	public static String RIGHT_JOIN = " RIGHT JOIN ";
	public static String FULL_JOIN = " FULL JOIN ";
	private String joinType;
	private String table;
	private String joinCondition;
	
	/**
	 * 
	 * @param join
	 * @param table
	 * @param joinCondition
	 */
	public QueryJoin(String joinType, String table, String joinCondition) {
		
		this.joinType = joinType;
		this.table = table;
		this.joinCondition = joinCondition;
	}
	
	public String getJoin() {
		
		return joinType + table + " ON " + joinCondition; 
	}
}
