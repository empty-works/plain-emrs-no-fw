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
		PreparedStatement preparedStatementUser = null;
		
		String queryUser = "insert into users(user_id, user_password, user_email_address, user_enabled, user_created_on, current_facility_id, "
				+ "user_date_of_birth, "
				+ "user_first_name, user_middle_initial, user_last_name) values (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			preparedStatementUser = con.prepareStatement(queryUser);
			preparedStatementUser.setString(1, userId);
			preparedStatementUser.setString(2, userPassword);
			preparedStatementUser.setString(3, userEmail);
			preparedStatementUser.setBoolean(4, userEnabled);
			preparedStatementUser.setTimestamp(5, java.sql.Timestamp.valueOf(userCreated));
			preparedStatementUser.setString(6, userFacilityId);
			preparedStatementUser.setDate(7, java.sql.Date.valueOf(userDob));
			preparedStatementUser.setString(8, userFirstName);
			preparedStatementUser.setString(9, userMiddleInitial);
			preparedStatementUser.setString(10, userLastName);

			int i = preparedStatementUser.executeUpdate();
			if(i != 0) return USERDAO_SUCCESS;
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatementUser, null);
		}
		
		return "Something went wrong. Could not add user.";
	}
}
