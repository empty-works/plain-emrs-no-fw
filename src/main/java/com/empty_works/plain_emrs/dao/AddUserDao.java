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
		
		String queryUser = "INSERT INTO users(user_id, user_password, user_email_address, user_enabled, user_created_on, current_facility_id, "
				+ "user_date_of_birth, user_first_name, user_middle_initial, user_last_name) values (?,?,?,?,?,?,?,?,?,?)";
		
		String queryRole = "INSERT INTO authorities(user_id, authority) values (?,?)";
		
		String queryUserLog = "";

		boolean exceptionThrown = false;
		String thrownResult = "";
		
		try (Connection con = ConnectionUtil.getConnection()) {
			
			try (PreparedStatement preparedStatement = con.prepareStatement(queryUser)) {
				
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
			}
			catch (SQLException e) {
				
				exceptionThrown = true;
				thrownResult = "Could not add user to users table!";
			}
			try (PreparedStatement preparedStatement = con.prepareStatement(queryRole)) {
				
				preparedStatement.setString(1, user.getUserId());
				preparedStatement.setString(2, user.getRole());
			}
			catch (SQLException e) {
				
				exceptionThrown = true;
				thrownResult = "Could not add role to authorities table!";
			}
		}
		catch (SQLException e) {
			
			
		}
		
		return "Something went wrong. Could not add user.";
	}
}
