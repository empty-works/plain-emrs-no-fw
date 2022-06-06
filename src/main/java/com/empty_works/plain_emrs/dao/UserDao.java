package com.empty_works.plain_emrs.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.empty_works.plain_emrs.beans.UserBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;
import com.empty_works.plain_emrs.util.QueryUtil;

public class UserDao {

	final public static String USERDAO_SUCCESS = "Success!";
	
	public static UserBean getUser(String username) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = QueryUtil.selectWithCondition("users", "user_name", "user_email_address", "user_enabled", "user_created_on", "user_id", 
				"nonpatient_id", "current_facility_id");
		
		System.out.println("User get query: " + query);
		
		UserBean user = new UserBean();

		try {

			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			// Check if the result set is empty.
			if(resultSet.next()) {InputStream stream = resultSet.getBinaryStream(1);}
			
			user.setUsername(username);
			user.setEmailAddress(resultSet.getString("user_email_address"));
			user.setUserEnabled(resultSet.getBoolean("user_enabled"));
			user.setDateCreated(resultSet.getObject("user_created_on", LocalDateTime.class));
			user.setPatientId(resultSet.getString("user_id"));
			user.setNonPatientId(resultSet.getString("nonpatient_id"));
			user.setCurrentFacilityId(resultSet.getString("current_facility_id"));
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatement, null);
		}
		
		return user;
	}
}
