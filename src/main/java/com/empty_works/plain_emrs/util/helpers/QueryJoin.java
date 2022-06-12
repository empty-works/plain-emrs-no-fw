package com.empty_works.plain_emrs.util.helpers;

public class QueryJoin {

	private static String JOIN = " JOIN ";
	private static String LEFT_JOIN = " LEFT JOIN ";
	private static String RIGHT_JOIN = " RIGHT JOIN ";
	private static String FULL_JOIN = " FULL JOIN ";
	private static String join;
	private static String table;
	private static String joinCondition;
	
	/**
	 * 
	 * @param join
	 * @param table
	 * @param joinCondition
	 */
	public QueryJoin(String join, String table, String joinCondition) {
		
		this.join = join;
		this.table = table;
		this.joinCondition = joinCondition;
	}
	
	public String getJoin() {
		
		return join + " ON " + joinCondition; 
	}
}
