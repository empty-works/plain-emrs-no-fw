package com.empty_works.plain_emrs.util;

public class QueryUtil {

	String tableName;
	String condition;
	StringBuilder fields;
	
	public QueryUtil() {
		
	}
	
	public void setTable(String tableName) {
		
		this.tableName = tableName;
	}
	
	public void setFields(String ... args) {
		
		for(String arg : args) {
			
			fields.append(arg);
		}
	}
	
	public void setCondition(String condition) {
		
		this.condition = condition;
	}
	
	
	/**
	 * 
	 * @param table
	 * @param args DAO fields
	 * @return
	 */
	public static String insert(String table, String ... args) {
		
		StringBuilder sb = new StringBuilder("insert into ");
		int counter = 0;
		sb.append(table);
		sb.append("(");
		for(String arg : args) {
			
			sb.append(arg);
			sb.append(",");
			counter++;
		}

		// Remove last comma 
		sb.deleteCharAt(sb.length() - 1);

		sb.append(")");
		sb.append(" values (");
		for(int i = 0; i < counter; i++) {
			
			sb.append("?");
			sb.append(",");
		}

		// Remove last comma
		sb.deleteCharAt(sb.length() - 1);
		sb.append(")");

		return sb.toString();
	}
	
	/**
	 * 
	 * @param table
	 * @param condition
	 * @param args
	 * @return
	 */
	public static String selectWithCondition(String table, String condition, String ... args) {
		
		StringBuilder sb = new StringBuilder(selectAll(table, args));
		sb.append(" where ");
		sb.append(condition);
		sb.append("=?");
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @param table
	 * @param args
	 * @return
	 */
	public static String selectAll(String table, String ... args) {
		
		StringBuilder sb = new StringBuilder("select ");
		for(String arg : args) {
			
			sb.append(arg);
			sb.append(",");
		}
		
		// Remove last comma
		sb.deleteCharAt(sb.length() - 1);
		
		sb.append(" from ");
		sb.append(table);
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @param table
	 * @param condition
	 * @param args
	 * @return
	 */
	public static String updateWithCondition(String table, String condition, String ... args) {
		
		StringBuilder sb = new StringBuilder("update ");
		sb.append(table);
		sb.append(" set ");
		for(String arg : args) {
			
			sb.append(arg);
			sb.append("=?,");
		}
		
		// Remove last comma
		sb.deleteCharAt(sb.length() - 1);
		
		sb.append(" where ");
		sb.append(condition);
		sb.append("=?");
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @param table
	 * @param args
	 * @return
	 */
	public static String updateAll(String table, String ... args) {
		
		StringBuilder sb = new StringBuilder("update ");
		sb.append(table);
		sb.append(" set ");
		for(String arg : args) {
			
			sb.append(arg);
			sb.append("=?,");
		}
		
		// Remove last comma
		sb.deleteCharAt(sb.length() - 1);
		
		return sb.toString();
	}
}