package com.empty_works.plain_emrs.util.helpers;

public class QueryField {

	public static String STRING = "String";
	public static String INT = "int";
	public static String DATE = "date";
	public static String DATE_TIME = "dateTime";
	public static String DOUBLE = "double";
	
	private String type;
	private String field;
	
	public void setString(String field) {
		
		this.field = field;
		type = STRING;
	}
	
	public void setInt(String field) {
		
		this.field = field;
		type = INT;
	}
	
	public void setDate(String field) {
		
		this.field = field;
		type = DATE;
	}
	
	public void setDateTime(String field) {
		
		this.field = field;
		type = DATE_TIME;
	}
	
	public void setDouble(String field) {
		
		this.field = field;
		type = DOUBLE;
	}
	
	public String getType() {
		
		return type;
	}
	
	public String getField() {
		
		return field;
	}
}
