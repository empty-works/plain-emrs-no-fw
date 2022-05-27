package com.empty_works.plain_emrs.util;

import com.empty_works.plain_emrs.beans.PatientBean;

public class QueryUtil {

	/**
	 * 
	 * @param table
	 * @param args DAO fields
	 * @return
	 */
	public static String add(String table, String ... args) {
		
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
	public static String getWithCondition(String table, String condition, String ... args) {
		
		StringBuilder sb = new StringBuilder(getAll(table, args));
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
	public static String getAll(String table, String ... args) {
		
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