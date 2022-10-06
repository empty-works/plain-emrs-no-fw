package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.empty_works.plain_emrs.util.ConnectionUtil;

public class AuthoritiesDao {

	public static String AUTHORITIESDAO_SUCCESS = "Successfully added new authority.";
	
	public static String add(String userId, String userRole) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		con = ConnectionUtil.getConnection();
		String query = "insert into authorities(user_id, authority) values (?,?)";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userRole);
			int i = preparedStatement.executeUpdate();
			if(i != 0) return AUTHORITIESDAO_SUCCESS;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatement, null);
		}
		
		return "Something went wrong with adding a user authority to the database!";
	}
}
