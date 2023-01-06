package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserBean extends GeneralBean implements BeanDaoInterface {

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
	@Override
	public String getQuery() {
		return "INSERT INTO users(user_id, user_password, user_email_address, user_enabled, user_created_on, current_facility_id, "
				+ "user_date_of_birth, user_first_name, user_middle_initial, user_last_name) values (?,?,?,?,?,?,?,?,?,?)";
	}
	@Override
	public String getErrorMessage() {
		return "Could not add user to users table!";
	}
	@Override
	public int prepareStatments(PreparedStatement preparedStatement) throws SQLException {
		
		System.out.println("Adding user...");
		preparedStatement.setString(1, getUserId());
		preparedStatement.setString(2, getUserPassword());
		preparedStatement.setString(3, getEmailAddress());
		preparedStatement.setBoolean(4, isUserEnabled());
		preparedStatement.setTimestamp(5, java.sql.Timestamp.valueOf(getDateCreated()));
		preparedStatement.setString(6, getCurrentFacilityId());
		preparedStatement.setDate(7, java.sql.Date.valueOf(getDateOfBirth()));
		preparedStatement.setString(8, getFirstName());
		preparedStatement.setString(9, getMiddleInitial());
		preparedStatement.setString(10, getLastName());
		return preparedStatement.executeUpdate();
	}
}
