package com.empty_works.plain_emrs.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.UserBean;
import com.empty_works.plain_emrs.util.helpers.QueryCondition;
import com.empty_works.plain_emrs.util.helpers.QueryDataType;
import com.empty_works.plain_emrs.util.helpers.QueryField;
import com.empty_works.plain_emrs.util.helpers.SelectQueryResult;

public class SelectQueryDB {

	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private SelectQueryResult selectQueryResult;
	
	public SelectQueryDB(SelectQueryResult selectQueryResult) {
		
		this.selectQueryResult = selectQueryResult;
	}
	
	public UserBean get() {
		
		con = ConnectionUtil.getConnection();
		UserBean user = new UserBean();
		try {

			// Insert any matches for conditions here
			preparedStatement = con.prepareStatement(selectQueryResult.getFullQueryString());
			setMatches();
			resultSet = preparedStatement.executeQuery();
			// Check if the result set is empty.
			if(resultSet.next()) {InputStream stream = resultSet.getBinaryStream(1);}
			
			// Set bean data from result set
			List<QueryField> fieldList = new ArrayList<>();
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatement, resultSet);
		}

		return user;
	}
	
	public void setMatches() {
		
		try {
			
			for(int i = 0; i < selectQueryResult.getConditionList().size(); i++) {
				
				switch(selectQueryResult.getConditionList().get(i).getDataType()) {
				
				case QueryDataType.STRING : 
					preparedStatement.setString(i + 1, (String)selectQueryResult.getConditionList().get(i).getMatch());
					break;
				case QueryDataType.INT : 
					preparedStatement.setInt(i + 1, (Integer)selectQueryResult.getConditionList().get(i).getMatch());
					break;
				case QueryDataType.DOUBLE : 
					preparedStatement.setDouble(i + 1, (Double)selectQueryResult.getConditionList().get(i).getMatch());
					break;
				case QueryDataType.DATE: 
					preparedStatement.setObject(i + 1, (LocalDate)selectQueryResult.getConditionList().get(i).getMatch());
					break;
				case QueryDataType.DATE_TIME: 
					preparedStatement.setObject(i + 1, (LocalDateTime)selectQueryResult.getConditionList().get(i).getMatch());
					break;
				}
			}
		} catch(SQLException e) {
			
			e.getStackTrace();
		}
	}
	
	/**
	 * 
	 * @param selectQueryResult
	 * @return matchString
	 */
	String setMatchesTest() {
		
		StringBuilder sbForTest = new StringBuilder();

		for(int i = 0; i < selectQueryResult.getConditionList().size(); i++) {
			
			switch(selectQueryResult.getConditionList().get(i).getDataType()) {
			
			case QueryDataType.STRING : 
				sbForTest.append(QueryDataType.STRING);
				sbForTest.append(selectQueryResult.getConditionList().get(i).getMatch());
				break;
			case QueryDataType.INT : 
				sbForTest.append(QueryDataType.INT);
				sbForTest.append(selectQueryResult.getConditionList().get(i).getMatch().toString());
				break;
			case QueryDataType.DOUBLE : 
				sbForTest.append(QueryDataType.DOUBLE);
				sbForTest.append(selectQueryResult.getConditionList().get(i).getMatch().toString());
				break;
			case QueryDataType.DATE: 
				sbForTest.append(QueryDataType.DATE);
				sbForTest.append(selectQueryResult.getConditionList().get(i).getMatch().toString());
				break;
			case QueryDataType.DATE_TIME: 
				sbForTest.append(QueryDataType.DATE_TIME);
				sbForTest.append(selectQueryResult.getConditionList().get(i).getMatch().toString());
				break;
			}
		}

		return sbForTest.toString();
	}
}
