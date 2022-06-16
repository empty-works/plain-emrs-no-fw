package com.empty_works.plain_emrs.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.UserBean;
import com.empty_works.plain_emrs.util.helpers.SelectQueryResult;

public class SelectQueryDB {

	Connection con = null;
	PreparedStatement preparedStatement = null;
	private SelectQueryResult selectQueryResult;
	
	public SelectQueryDB(SelectQueryResult selectQueryResult) {
		
		con = ConnectionUtil.getConnection();
		this.selectQueryResult = selectQueryResult;
	}
	
	public UserBean send() {
		
		try {

			UserBean user = new UserBean();
			preparedStatement = con.prepareStatement(selectQueryResult.getFullQueryString());
			ResultSet rs = preparedStatement.executeQuery();
			
			//	Set 
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
