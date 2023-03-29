package com.empty_works.plain_emrs.beans;

public class EmergencyContactsBean {

	private String firstName, middleInitial, lastName;
	private String phoneNumber, email;
	private String userPatientId;
	
	public EmergencyContactsBean(String userPatientId) {
		this.userPatientId = userPatientId;
	}
	public String getUserPatientId() {
		return userPatientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
