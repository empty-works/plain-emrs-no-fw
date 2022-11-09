package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UserActivityLogBean implements BeanDaoInterface {

	private String userId;
	private String medicalRecordId;
	private LocalDateTime userDateTimeOfActivity;
	private String activityDescription;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMedicalRecordId() {
		return medicalRecordId;
	}
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
	public LocalDateTime getUserDateTimeOfActivity() {
		return userDateTimeOfActivity;
	}
	public void setUserDateTimeOfActivity(LocalDateTime userDateTimeOfActivity) {
		this.userDateTimeOfActivity = userDateTimeOfActivity;
	}
	public String getActivityDescription() {
		return activityDescription;
	}
	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}
	@Override
	public String getQuery() {
		return "INSERT INTO user_activity_logs(user_id, medical_record_id, user_date_time_of_activity, activity_description) "
				+ "values (?,?,?,?)";
	}
	@Override
	public String getErrorMessage() {
		return "Could not add user activity log to user_activity_logs table!";
	}
	@Override
	public int prepareStatments(PreparedStatement preparedStatement) throws SQLException {

		System.out.println("Adding user activity log...");
		preparedStatement.setString(1, getUserId());
		preparedStatement.setString(2, getMedicalRecordId());
		preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(getUserDateTimeOfActivity()));
		preparedStatement.setString(4, getActivityDescription());
		return preparedStatement.executeUpdate();
	}
}
