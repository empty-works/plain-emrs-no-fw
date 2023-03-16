package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicalRecordMedicationBean implements MedicalRecordInterface, BeanDaoInterface {

	private int medicationId;
	private String medicalRecordId;
	private String medicationName;
	private boolean medicationIsCurrent;
	private String medicationDescription;

	public int getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(int medicationId) {
		this.medicationId = medicationId;
	}

	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	public boolean isMedicationCurrent() {
		return medicationIsCurrent;
	}

	public void setMedicationIsCurrent(boolean medicationIsCurrent) {
		this.medicationIsCurrent = medicationIsCurrent;
	}

	public String getMedicationDescription() {
		return medicationDescription;
	}

	public void setMedicationDescription(String medicationDescription) {
		this.medicationDescription = medicationDescription;
	}

	@Override
	public String getWriteQuery() {
		return "INSERT INTO medication(medication_id, medical_record_id, medication_name, medication_is_current, medication_description) "
				+ "values (?,?,?,?,?)";
	}

	@Override
	public String getErrorMessage() {
		return "Could not add to the medication table!";
	}

	@Override
	public int prepareStatments(PreparedStatement preparedStatement) throws SQLException {
		System.out.println("Adding to the medication table...");
		preparedStatement.setInt(1, getMedicationId());
		preparedStatement.setString(2, getMedicalRecordId());
		preparedStatement.setString(3, getMedicationName());
		preparedStatement.setBoolean(4, isMedicationCurrent());
		preparedStatement.setString(5, getMedicationDescription());
		return preparedStatement.executeUpdate();
	}

	@Override
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	@Override
	public String getMedicalRecordId() {
		return medicalRecordId;
	}
}
