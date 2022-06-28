package com.empty_works.plain_emrs.util;

import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.util.helpers.QueryCondition;
import com.empty_works.plain_emrs.util.helpers.QueryField;
import com.empty_works.plain_emrs.util.helpers.QueryJoin;
import com.empty_works.plain_emrs.util.helpers.SelectQueryResult;

/*
 * To use the SelectQueryCreator, create a SelectQueryCreator object. Set the table and add the fields with QueryField objects. 
 * Then optionally add conditions or joins. Then get result by calling the select method. 
 * */
public class SelectQueryCreator {

	private String tableName;
	private List<QueryField> fieldList = new ArrayList<>();
	private List<QueryCondition> conditionList = new ArrayList<>();
	private String fields;
	private StringBuilder fieldsSb = new StringBuilder();
	private QueryJoin join = null;
	private StringBuilder fullQuery = new StringBuilder();
	private String fullQueryString;
	private SelectQueryResult result = new SelectQueryResult();

	/**
	 * 
	 * @param tableName
	 */
	public void setTable(String tableName) {
		
		this.tableName = tableName;
	}

	/**
	 * 
	 * @param join
	 */
	public void setJoin(QueryJoin join) {
		
		this.join = join;
	}
	
	/**
	 * 
	 * @param condition
	 */
	public void addCondition(QueryCondition condition) {
		
		conditionList.add(condition);
	}
	
	/**
	 * 
	 * @param field
	 */
	public void addField(QueryField field) {
		
		fieldList.add(field);
	}
	
	/**
	 * 
	 * @return SelectQueryResult result
	 */
	public SelectQueryResult select() {
		
		fullQuery.append("SELECT ");

		// Create query from field list
		fields = getFields();
		fullQuery.append(fields);
		result.setFieldList(fieldList);
		
		// From table
		fullQuery.append(" FROM ");
		fullQuery.append(tableName);
		
		// Join tables
		if(join != null) {
			
			fullQuery.append(join.getJoin());
		}
		
		// Add conditions if they exist
		if(!conditionList.isEmpty()) {
			
			fullQuery.append(" WHERE ");
			for(QueryCondition condition : conditionList) {
				
				fullQuery.append(condition.getCondition());
			}
		}
		
		fullQueryString = fullQuery.toString();
		result.setFullQueryString(fullQueryString);
		return result;
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
}
