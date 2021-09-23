package com.empty_works.plain_emrs.beans;

import java.util.Date;

public class GeneratedUserBean {

	private String username;
	private String password;
	private String emailAddress;
	private boolean enabled;
	private Date createdOn;
	private int patientId;
	private int nonpatientId;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getNonpatientId() {
		return nonpatientId;
	}
	public void setNonpatientId(int nonpatientId) {
		this.nonpatientId = nonpatientId;
	}
}
