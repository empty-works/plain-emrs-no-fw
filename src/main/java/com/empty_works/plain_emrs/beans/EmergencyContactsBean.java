package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmergencyContactsBean implements BeanDaoInterface {

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
	@Override
	public String getQuery() {
		return "INSERT INTO emergency_contacts(user_id, emergency_contact_given_name, emergency_contact_middle_initial, emergency_contact_last_name, "
				+ "emergency_contact_phone_number, emergency_contact_email_address) "
				+ "VALUES (?,?,?,?,?,?)";
	}
	@Override
	public String getErrorMessage() {
		return "Could not add emergency contact to emergency_contacts!";
	}
	@Override
	public int prepareStatments(PreparedStatement preparedStatement) throws SQLException {
		System.out.println("Adding emergency contact...");
		preparedStatement.setString(1, getUserPatientId());
		preparedStatement.setString(2, getFirstName());
		preparedStatement.setString(3, getMiddleInitial());
		preparedStatement.setString(4, getLastName());
		preparedStatement.setString(5, getPhoneNumber());
		preparedStatement.setString(6, getEmail());
		return preparedStatement.executeUpdate();
	}
}
