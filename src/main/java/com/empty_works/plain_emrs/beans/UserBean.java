package com.empty_works.plain_emrs.beans;

import java.time.LocalDateTime;

public class UserBean extends GeneralBean {

	private String username;
	private String emailAddress;
	private boolean userEnabled;
	private LocalDateTime dateCreated;
	private String patientId;
	private String nonPatientId;
	private String currentFacilityId;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public boolean isUserEnabled() {
		return userEnabled;
	}
	public void setUserEnabled(boolean userEnabled) {
		this.userEnabled = userEnabled;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getNonPatientId() {
		return nonPatientId;
	}
	public void setNonPatientId(String nonPatientId) {
		this.nonPatientId = nonPatientId;
	}
	public String getCurrentFacilityId() {
		return currentFacilityId;
	}
	public void setCurrentFacilityId(String currentFacilityId) {
		this.currentFacilityId = currentFacilityId;
	}
}
