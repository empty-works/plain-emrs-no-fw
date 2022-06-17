package com.empty_works.plain_emrs.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
			setMatches();
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
				
				case QueryDataType.STRING : preparedStatement.setString(i + 1, (String)selectQueryResult.getConditionList().get(i).getMatch());
					sbForTest.append(QueryDataType.STRING);
					sbForTest.append(selectQueryResult.getConditionList().get(i).getMatch());
					break;
				case QueryDataType.INT : preparedStatement.setInt(i + 1, (Integer)selectQueryResult.getConditionList().get(i).getMatch());
					sbForTest.append(QueryDataType.INT);
					sbForTest.append(selectQueryResult.getConditionList().get(i).getMatch().toString());
					break;
				case QueryDataType.DOUBLE : preparedStatement.setDouble(i + 1, (Double)selectQueryResult.getConditionList().get(i).getMatch());
					sbForTest.append(QueryDataType.DOUBLE);
					sbForTest.append(selectQueryResult.getConditionList().get(i).getMatch().toString());
					break;
				case QueryDataType.DATE: preparedStatement.setObject(i + 1, (LocalDate)selectQueryResult.getConditionList().get(i).getMatch());
					sbForTest.append(QueryDataType.DATE);
					sbForTest.append(selectQueryResult.getConditionList().get(i).getMatch().toString());
					break;
				case QueryDataType.DATE_TIME: preparedStatement.setObject(i + 1, (LocalDateTime)selectQueryResult.getConditionList().get(i).getMatch());
					sbForTest.append(QueryDataType.DATE_TIME);
					sbForTest.append(selectQueryResult.getConditionList().get(i).getMatch().toString());
					break;
				}
			}
		} catch(SQLException e) {
			
			e.getStackTrace();
		}
		return sbForTest.toString();
	}
}
