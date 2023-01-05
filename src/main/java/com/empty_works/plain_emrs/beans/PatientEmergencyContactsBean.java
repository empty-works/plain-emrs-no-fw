package com.empty_works.plain_emrs.beans;

public class PatientEmergencyContactsBean {

	private String userId, pecId;
	
	PatientEmergencyContactsBean(String userId) {
	
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPecId() {
		return pecId;
	}

	public void setPecId(String pecId) {
		this.pecId = pecId;
	}
}