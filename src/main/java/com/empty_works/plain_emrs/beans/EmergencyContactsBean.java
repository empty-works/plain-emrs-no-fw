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
		return "INSERT INTO emergency_contacts(emergency_contact_given_name, emergency_contact_middle_initial, emergency_contact_last_name, "
				+ "emergency_contact_phone_number, emergency_contact_email_address) "
				+ "OUTPUT INSERTED.emergency_contact_id," + userPatientId + " INTO patient_emergency_contacts(patient_emergency_contact_id, user_id) "
				+ "VALUES (?,?,?,?,?)";
	}
	@Override
	public String getErrorMessage() {
		return "Could not add emergency contact to emergency_contacts!";
	}
	@Override
	public int prepareStatments(PreparedStatement preparedStatement) throws SQLException {
		System.out.println("Adding emergency contact...");
		preparedStatement.setString(1, getFirstName());
		preparedStatement.setString(2, getMiddleInitial());
		preparedStatement.setString(3, getLastName());
		preparedStatement.setString(4, getPhoneNumber());
		preparedStatement.setString(5, getEmail());
		return preparedStatement.executeUpdate();
	}
}
