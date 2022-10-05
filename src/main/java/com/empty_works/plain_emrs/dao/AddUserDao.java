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
	
	public static String getUser(UserBean user, String facilityId) { 
		
		String userId = user.getUserId();
		String userPassword = user.getUserPassword();
		String userEmail = user.getEmailAddress();
		boolean userEnabled = user.isUserEnabled();
		LocalDateTime userCreated = user.getDateCreated();
		String userFacilityId = user.getCurrentFacilityId();
		LocalDate userDob = user.getDateOfBirth();
		String userFirstName = user.getFirstName();
		String userMiddleInitial = user.getMiddleInitial();
		String userLastName = user.getLastName();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "insert into users(user_id, user_password, user_email_address, user_enabled, user_created_on, current_facility_id, "
				+ "user_date_of_birth, "
				+ "user_first_name, user_middle_initial, user_last_name) values (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userPassword);
			preparedStatement.setString(3, userEmail);
			preparedStatement.setBoolean(4, userEnabled);
			preparedStatement.setTimestamp(5, java.sql.Timestamp.valueOf(userCreated));
			preparedStatement.setString(6, userFacilityId);
			preparedStatement.setDate(7, java.sql.Date.valueOf(userDob));
			preparedStatement.setString(8, userFirstName);
			preparedStatement.setString(9, userMiddleInitial);
			preparedStatement.setString(10, userLastName);

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
