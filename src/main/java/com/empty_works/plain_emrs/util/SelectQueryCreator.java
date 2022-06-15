package com.empty_works.plain_emrs.util;

import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.util.helpers.QueryCondition;
import com.empty_works.plain_emrs.util.helpers.QueryField;
import com.empty_works.plain_emrs.util.helpers.QueryJoin;

public class SelectQueryCreator {

	private String tableName;
	private List<QueryField> fieldList = new ArrayList<>();
	private List<QueryCondition> conditionList = new ArrayList<>();
	private String fields;
	private StringBuilder fieldsSb = new StringBuilder();
	private QueryJoin join = null;
	private StringBuilder fullQuery = new StringBuilder();

	public void setTable(String tableName) {
		
		this.tableName = tableName;
	}

	public void setJoin(QueryJoin join) {
		
		this.join = join;
	}
	
	public void addCondition(QueryCondition condition) {
		
		conditionList.add(condition);
	}
	
	public void addField(QueryField field) {
		
		fieldList.add(field);
	}
	
	public String select() {
		
		fullQuery.append("SELECT ");

		// Create query from field list
		fields = getFields();
		fullQuery.append(fields);
		
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
		
		return fullQuery.toString();
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
