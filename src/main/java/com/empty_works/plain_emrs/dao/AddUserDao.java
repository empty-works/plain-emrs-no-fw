package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.empty_works.plain_emrs.beans.UserAccessLogBean;
import com.empty_works.plain_emrs.beans.UserActivityLogBean;
import com.empty_works.plain_emrs.beans.UserBean;
import com.empty_works.plain_emrs.beans.UserLoginLogBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class AddUserDao {

	final public static String USERDAO_SUCCESS = "User successfully added!";
	
	public static String add(UserBean user, UserAccessLogBean userAccess, UserLoginLogBean userLogin, UserActivityLogBean userActivity) { 
		
		String queryUser = "INSERT INTO users(user_id, user_password, user_email_address, user_enabled, user_created_on, current_facility_id, "
				+ "user_date_of_birth, user_first_name, user_middle_initial, user_last_name) values (?,?,?,?,?,?,?,?,?,?)";
		
		String queryRole = "INSERT INTO authorities(user_id, authority) values (?,?)";
		
		String queryUserAccessLog = "INSERT INTO user_access_logs(user_id, user_date_time_of_access, medical_record_id) values (?,?,?)";
		
		String queryUserLoginLog = "INSERT INTO user_login_logs(user_id, user_date_time_of_visit) values (?,?)"; 
	
		String queryUserActivity = "INSERT INTO user_activity_logs(user_id, medical_record_id, user_date_time_of_activity, activity_description) "
				+ "values (?,?,?,?)";

		boolean exceptionThrown = false;
		String thrownResult = "";
		
		try (Connection con = ConnectionUtil.getConnection()) {
			
			try (PreparedStatement preparedStatement = con.prepareStatement(queryUser)) {
				
				System.out.println("Adding user...");
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
				
				System.out.println("Adding role to authorities table...");
				preparedStatement.setString(1, user.getUserId());
				preparedStatement.setString(2, user.getRole());
			}
			catch (SQLException e) {
				
				exceptionThrown = true;
				thrownResult = "Could not add role to authorities table!";
			}
			try (PreparedStatement preparedStatement = con.prepareStatement(queryUserAccessLog)) {
				
				System.out.println("Adding user access log...");
				preparedStatement.setString(1, userAccess.getUserId());
				preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf(userAccess.getUserDateTimeOfAccess()));
				preparedStatement.setString(3, userAccess.getMedicalRecordId());
			}
			catch (SQLException e) {
				
				exceptionThrown = true;
				thrownResult = "Could not add user access log to user_access_logs table!";
			}
			try (PreparedStatement preparedStatement = con.prepareStatement(queryUserLoginLog)) {
				
				System.out.println("Adding user login log...");
				preparedStatement.setString(1, userLogin.getUserId());
				preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf(userLogin.getUserDateTimeOfVisit()));
			}
			try (PreparedStatement preparedStatement = con.prepareStatement(queryUserActivity)) {
				
				System.out.println("Adding user activity log...");
				preparedStatement.setString(1, userActivity.getUserId());
				preparedStatement.setString(2, userActivity.getMedicalRecordId());
				preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(userActivity.getUserDateTimeOfActivity()));
				preparedStatement.setString(4, userActivity.getActivityDescription());
			}
			catch (SQLException e) {
				
				exceptionThrown = true;
				thrownResult = "Could not add user activity log to user_activity_logs table!";
			}
		}
		catch (SQLException e) {
			
			exceptionThrown = true;
			thrownResult = "Connection failed in user DAO.";
		}
		if(exceptionThrown) {
			
			return thrownResult;
		}
		return USERDAO_SUCCESS;
	}
}
