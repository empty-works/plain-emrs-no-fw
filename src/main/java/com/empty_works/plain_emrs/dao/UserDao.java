package com.empty_works.plain_emrs.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.UserBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;
import com.empty_works.plain_emrs.util.PasswordUtil;
import com.empty_works.plain_emrs.util.QueryUtil;
import com.empty_works.plain_emrs.util.SelectQueryCreator;
import com.empty_works.plain_emrs.util.helpers.QueryField;

public class UserDao {

	final public static String USERDAO_SUCCESS = "User successfully added!";
	
	public static UserBean getUser(String username) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		SelectQueryCreator queryCreator = new SelectQueryCreator();
		queryCreator.setTable("users");
		queryCreator.addField(new QueryField(QueryField.STRING, "user_email_address"));
		
		
		String query = "SELECT user_email_address, user_enabled, user_created_on, patient_id, "
				+ "nonpatient_id, current_facility_id FROM users WHERE user_name=?";
		
		System.out.println("User get query: " + query);
		
		UserBean user = new UserBean();

		try {

			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			// Check if the result set is empty.
			if(resultSet.next()) {InputStream stream = resultSet.getBinaryStream(1);}
			
			user.setUserId(username);
			user.setEmailAddress(resultSet.getString("user_email_address"));
			user.setUserEnabled(resultSet.getBoolean("user_enabled"));
			user.setDateCreated(resultSet.getObject("user_created_on", LocalDateTime.class));
			//user.setPatientId(resultSet.getString("user_id"));
			//user.setNonPatientId(resultSet.getString("nonpatient_id"));
			user.setCurrentFacilityId(resultSet.getString("current_facility_id"));
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatement, null);
		}
		
		return user;
	}
	
	public static List<UserBean> getList(String firstName, String lastName) {
		
		List<UserBean> userList = new ArrayList<>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String query = "select user_name, user_email_address, user_enabled, user_created_on, patient_id, "
				+ "nonpatient_id, current_facility_id";

		try {

			preparedStatement = con.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				UserBean user = new UserBean();
				user.setUserId(resultSet.getString("user_name"));
				user.setEmailAddress(resultSet.getString("user_email_address"));
				user.setUserEnabled(resultSet.getBoolean("user_enabled"));
				user.setDateCreated(resultSet.getObject("user_created_on", LocalDateTime.class));
				//user.setPatientId(resultSet.getString("patient_id"));
				//user.setNonPatientId(resultSet.getString("nonpatient_id"));
				user.setCurrentFacilityId(resultSet.getString("current_facility_id"));
				userList.add(user);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatement, resultSet);
		}
		
		return userList;
	}
	
	public static String add(UserBean user) throws SQLException {
		
		String query = "INSERT INTO users(user_id, user_password, user_email_address, user_enabled, user_created_on, current_facility_id, "
				+ "user_date_of_birth, user_first_name, user_middle_initial, user_last_name) values (?,?,?,?,?,?,?,?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
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
				success = preparedStatement.executeUpdate();
			}
		}
		
		if(success == 0) {
			return "Could not add user to the database!";
		}
		return USERDAO_SUCCESS;
		/*
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, user.getUserId());
			short passwordLength = 7;
			preparedStatement.setString(2, PasswordUtil.generate(passwordLength));
			preparedStatement.setString(3, user.getEmailAddress());
			preparedStatement.setBoolean(4, user.isUserEnabled());
			preparedStatement.setObject(5, user.getDateCreated());
			//preparedStatement.setString(6, user.getPatientId());
			//preparedStatement.setString(7, user.getNonPatientId());
			preparedStatement.setString(8, user.getCurrentFacilityId());
			
			int i = preparedStatement.executeUpdate();
			if(i != 0) return USERDAO_SUCCESS;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			//ConnectionUtil.closeConnection(con, preparedStatement, null);
		}
		return "Something went wrong. User could not be added to the database!";

			*/
	}
}
