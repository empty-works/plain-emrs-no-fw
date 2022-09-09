package com.empty_works.plain_emrs.user_choices;

public class UserMaritalStatusUnit {

	private String maritalStatusId;
	private String maritalStatus;
	
	public UserMaritalStatusUnit(String maritalStatusId, String maritalStatus) {
		
		this.maritalStatusId = maritalStatusId;
		this.maritalStatus = maritalStatus;
	}
	
	public String getMaritalStatusId() {
		return maritalStatusId;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
}
