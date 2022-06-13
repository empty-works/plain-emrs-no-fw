package com.empty_works.plain_emrs.util.helpers;

public class QueryField {

	public static String STRING = "String";
	public static String INT = "int";
	public static String DATE = "date";
	public static String DATE_TIME = "dateTime";
	public static String DOUBLE = "double";
	
	private String type;
	private String field;
	
	public QueryField(String type, String field) {
		
		this.type = type;
		this.field = field;
	}
	
	public String getType() {
		
		return type;
	}
	
	public String getField() {
		
		return field;
	}
}
