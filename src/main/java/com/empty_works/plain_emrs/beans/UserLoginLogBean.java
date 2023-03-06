package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UserLoginLogBean implements BeanDaoInterface {

	private String userId;
	private LocalDateTime userDateTimeOfVisit;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public LocalDateTime getUserDateTimeOfVisit() {
		return userDateTimeOfVisit;
	}
	public void setUserDateTimeOfVisit(LocalDateTime userDateTimeOfVisit) {
		this.userDateTimeOfVisit = userDateTimeOfVisit;
	}
	@Override
	public String getWriteQuery() {
		return "INSERT INTO user_login_logs(user_id, user_date_time_of_visit) values (?,?)";
	}
	@Override
	public String getErrorMessage() {
		return "Could not add user login log to user_login_logs table!";
	}
	@Override
	public int prepareStatments(PreparedStatement preparedStatement) throws SQLException {

		System.out.println("Adding user login log...");
		preparedStatement.setString(1, getUserId());
		preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf(getUserDateTimeOfVisit()));
		return preparedStatement.executeUpdate();
	}
}
