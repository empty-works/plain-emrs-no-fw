package com.empty_works.plain_emrs.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PreparedStatementUtility {

	public static int get(String table, String ... args) {
		
		Connection con = ConnectionUtil.getConnection();

		return 0;
	}
	
	private static String makePS(String table, String ... args) {
		
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
}
