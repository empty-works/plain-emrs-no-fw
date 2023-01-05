package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientEmergencyContactsBean implements BeanDaoInterface {

	private String userId, pecId;
	
	public PatientEmergencyContactsBean(String userId) {
	
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

	@Override
	public String getQuery() {
		return "INSERT INTO patient_emergency_contacts(patient_emergency_contact_id, user_id) values (?,last_insert_id())";
	}

	@Override
	public String getErrorMessage() {
		return "Can't insert into patient_emergency_contacts table.";
	}

	@Override
	public int prepareStatments(PreparedStatement preparedStatement) throws SQLException {
		System.out.println("Inserting into patient_emergency_contacts junction table...");
		preparedStatement.setString(1, userId);
		return preparedStatement.executeUpdate();
	}
}