package com.empty_works.plain_emrs.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.util.helpers.QueryCondition;
import com.empty_works.plain_emrs.util.helpers.QueryField;

public class QueryUtil {

	private Connection con;
	private PreparedStatement preparedStatement = null;
	private StringBuilder fullQuery = new StringBuilder();
	private StringBuilder fieldsSb = new StringBuilder();
	private String fields;
	private String tableName;
	private String join = "";
	private List<QueryField> fieldList = new ArrayList<>();
	private List<QueryCondition> conditionList = new ArrayList<>();
	
	public QueryUtil() {
		
		// Make connection
		con = ConnectionUtil.getConnection();
	}
	
	public void setTable(String tableName) {
		
		this.tableName = tableName;
	}
	
	public void setJoin(String join) {
		
		this.join = join;
	}
	
	public void addCondition(QueryCondition condition) {
		
		conditionList.add(condition);
	}
	
	public void addField(QueryField field) {
		
		fieldList.add(field);
	}
	
	public int select() {
		
		fullQuery.append("select ");

		// Create query from field list
		fields = getFields();
		fullQuery.append(fields);
		
		// From table
		fullQuery.append(" FROM ");
		fullQuery.append(tableName);
		
		// Join tables
		fullQuery.append(" JOIN ");
		fullQuery.append(join);
		
		// Add conditions if they exist
		if(!conditionList.isEmpty()) {
			
			fullQuery.append(" WHERE ");
			for(QueryCondition condition : conditionList) {
				
				fullQuery.append(condition.getCondition());
			}
		}
		
		return 0;
	}

	private String getFields() {
		
		if(!fieldList.isEmpty()) {
			
			for(QueryField field : fieldList) {
				
				fieldsSb.append(field.getField());
				fieldsSb.append(",");
			}
			// Remove last comma.
			fieldsSb.deleteCharAt(fieldsSb.length() - 1);
		}
		return fieldsSb.toString();
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