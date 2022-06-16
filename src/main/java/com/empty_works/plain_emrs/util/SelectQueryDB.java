package com.empty_works.plain_emrs.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.UserBean;

public class SelectQueryDB {

	Connection con = null;
	PreparedStatement preparedStatement = null;
	private String selectQuery;
	
	public SelectQueryDB(String selectQuery) {
		
		con = ConnectionUtil.getConnection();
		this.selectQuery = selectQuery;
	}
	
	public UserBean send() {
		
		try {

			UserBean user = new UserBean();
			preparedStatement = con.prepareStatement(selectQuery);
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
