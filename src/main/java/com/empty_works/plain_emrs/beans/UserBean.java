package com.empty_works.plain_emrs.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserBean extends GeneralBean {

	// No password attribute because it's generated during user creation
	private String userId;
	private String userPassword;
	private String emailAddress;
	private boolean userEnabled;
	private LocalDateTime dateCreated;
	private LocalDate dateOfBirth;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String currentFacilityId;
	private String role;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String username) {
		this.userId = username;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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
		System.out.println("Get date created: " + dateCreated);
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		System.out.println("Set date created: " + dateCreated);
		this.dateCreated = dateCreated;
	}
	public LocalDate getDateOfBirth() {
		System.out.println("Get date of birth: " + dateOfBirth);
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		System.out.println("Set date of birth: " + dateOfBirth);
		this.dateOfBirth = dateOfBirth;
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
	public String getCurrentFacilityId() {
		return currentFacilityId;
	}
	public void setCurrentFacilityId(String currentFacilityId) {
		this.currentFacilityId = currentFacilityId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
