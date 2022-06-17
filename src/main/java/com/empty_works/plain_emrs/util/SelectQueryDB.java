package com.empty_works.plain_emrs.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.UserBean;
import com.empty_works.plain_emrs.util.helpers.QueryCondition;
import com.empty_works.plain_emrs.util.helpers.QueryDataType;
import com.empty_works.plain_emrs.util.helpers.SelectQueryResult;

public class SelectQueryDB {

	Connection con = null;
	PreparedStatement preparedStatement = null;
	private SelectQueryResult selectQueryResult;
	
	public SelectQueryDB(SelectQueryResult selectQueryResult) {
		
		con = ConnectionUtil.getConnection();
		this.selectQueryResult = selectQueryResult;
	}
	
	public UserBean get() {
		
		try {

			UserBean user = new UserBean();
			// Insert any matches for conditions here
			
			preparedStatement = con.prepareStatement(selectQueryResult.getFullQueryString());
			ResultSet rs = preparedStatement.executeQuery();
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	String setMatches() {
		
		StringBuilder sbForTest = new StringBuilder();
		try {
			
			for(int i = 0; i < selectQueryResult.getConditionList().size(); i++) {
				
				switch(selectQueryResult.getConditionList().get(i).getDataType()) {
				
				case QueryDataType.STRING : preparedStatement.setString(i + 1, selectQueryResult.getConditionList().get(i).getMatch());
					sbForTest.append(QueryDataType.STRING);
					sbForTest.append(selectQueryResult.getConditionList().get(i).getMatch());
				break;
				case QueryDataType.INT : preparedStatement.setInt(i + 1, selectQueryResult.getConditionList().get(i).getMatch());
				}
			}
		} catch(SQLException e) {
			
			
		}
		return sbForTest.toString();
	}
}
