package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.UserLoginLogBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class UserLoginLogDao {

	public static String add(UserLoginLogBean loginLogBean) throws SQLException {
		
		String query = "INSERT INTO user_login_logs(user_id, user_date_time_of_visit) values (?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				
				System.out.println("Adding user login log...");
				preparedStatement.setString(1, loginLogBean.getUserId());
				preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf(loginLogBean.getUserDateTimeOfVisit()));
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add login log to the database!";
		}
		return "Successfully added login log to the database!";
	}
}
