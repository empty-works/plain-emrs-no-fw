package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MedicalRecordBean implements PatientIdInterface, BeanDaoInterface {

	private String userId;
	private String medicalRecordId;
	private String patientCondition;
	private LocalDateTime medicalRecordCreatedOn;
	private boolean isActive;
	private String bloodTransfusionStatus;

	@Override
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String getUserId() {
		return userId;
	}
	public String getMedicalRecordId() {
		return medicalRecordId;
	}
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
	public String getPatientCondition() {
		return patientCondition;
	}
	public void setPatientCondition(String patientCondition) {
		this.patientCondition = patientCondition;
	}
	public LocalDateTime getMedicalRecordCreatedOn() {
		return medicalRecordCreatedOn;
	}
	public void setMedicalRecordCreatedOn(LocalDateTime medicalRecordCreatedOn) {
		this.medicalRecordCreatedOn = medicalRecordCreatedOn;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getBloodTransfusionStatus() {
		return bloodTransfusionStatus;
	}
	public void setBloodTransfusionStatus(String bloodTransfusionStatus) {
		this.bloodTransfusionStatus = bloodTransfusionStatus;
	}
	@Override
	public String getWriteQuery() {
		return "INSERT INTO medical_records(medical_record_id, user_id, patient_condition, medical_record_created_on, is_active, "
				+ "blood_transfusion_status) values (?,?,?,?,?,?)";
	}
	@Override
	public String getWriteErrorMessage() {
		return "Could not add medical record!";
	}
	@Override
	public int prepareWriteStatement(PreparedStatement preparedStatement) throws SQLException {

		System.out.println("Adding medical record...");
		preparedStatement.setString(1, getMedicalRecordId());
		preparedStatement.setString(2, getUserId());
		preparedStatement.setString(3, getPatientCondition());
		preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(getMedicalRecordCreatedOn()));
		preparedStatement.setBoolean(5, isActive());
		preparedStatement.setString(6, getBloodTransfusionStatus());
		return preparedStatement.executeUpdate();
	}
}
