package com.empty_works.plain_emrs.beans;

import java.time.LocalDateTime;

public class UserActivityLogBean {

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
}
