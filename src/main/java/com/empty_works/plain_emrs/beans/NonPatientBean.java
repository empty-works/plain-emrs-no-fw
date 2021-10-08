package com.empty_works.plain_emrs.beans;

public class NonPatientBean extends PersonBean {

	private String emailAddress;
	private String organization;
	private String description;

	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String email) {
		this.emailAddress = email;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
