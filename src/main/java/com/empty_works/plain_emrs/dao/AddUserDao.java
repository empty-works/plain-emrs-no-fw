package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.empty_works.plain_emrs.beans.UserBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class AddUserDao {

	final public static String USERDAO_SUCCESS = "User successfully added!";
	
	public static String add(UserBean user) { 
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String queryUser = "insert into users(user_id, user_password, user_email_address, user_enabled, user_created_on, current_facility_id, "
				+ "user_date_of_birth, "
				+ "user_first_name, user_middle_initial, user_last_name) values (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			preparedStatement = con.prepareStatement(queryUser);
			preparedStatement.setString(1, user.getUserId());
			preparedStatement.setString(2, user.getUserPassword());
			preparedStatement.setString(3, user.getEmailAddress());
			preparedStatement.setBoolean(4, user.isUserEnabled());
			preparedStatement.setTimestamp(5, java.sql.Timestamp.valueOf(user.getDateCreated()));
			preparedStatement.setString(6, user.getCurrentFacilityId());
			preparedStatement.setDate(7, java.sql.Date.valueOf(user.getDateOfBirth()));
			preparedStatement.setString(8, user.getFirstName());
			preparedStatement.setString(9, user.getMiddleInitial());
			preparedStatement.setString(10, user.getLastName());

			int i = preparedStatement.executeUpdate();
			if(i != 0) return USERDAO_SUCCESS;
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatement, null);
		}
		
		return "Something went wrong. Could not add user.";
	}
}
