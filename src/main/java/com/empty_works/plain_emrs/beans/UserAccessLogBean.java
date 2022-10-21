package com.empty_works.plain_emrs.beans;

import java.time.LocalDateTime;

public class UserAccessLogBean {

	private String userId;
	private LocalDateTime userDateTimeOfAccess;
	private String medicalRecordId;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public LocalDateTime getUserDateTimeOfAccess() {
		return userDateTimeOfAccess;
	}
	public void setUserDateTimeOfAccess(LocalDateTime userDateTimeOfAccess) {
		this.userDateTimeOfAccess = userDateTimeOfAccess;
	}
	public String getMedicalRecordId() {
		return medicalRecordId;
	}
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
}
