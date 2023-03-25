package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.UserActivityLogBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class UserActivityLogDao {

	public static String add(UserActivityLogBean userActivity) throws SQLException {
		
		String query = "INSERT INTO user_activity_logs(user_id, medical_record_id, user_date_time_of_activity, activity_description) "
				+ "VALUES (?,?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				System.out.println("Adding user activity log...");
				preparedStatement.setString(1, userActivity.getUserId());
				preparedStatement.setString(2, userActivity.getMedicalRecordId());
				preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(userActivity.getUserDateTimeOfActivity()));
				preparedStatement.setString(4, userActivity.getActivityDescription());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add user activity log to the database!";
		}
		return "Successfully added user activity log to the database!";
	}
}
