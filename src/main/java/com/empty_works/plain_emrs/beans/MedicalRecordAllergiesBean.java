package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordAllergyUnit;

public class MedicalRecordAllergiesBean implements MedicalRecordInterface, BeanDaoInterface {

	private int allergiesId;
	private String medicalRecordId;
	private String allergyName;
	private List<MedicalRecordAllergyUnit> allergyUnits;
	
	public int getAllergiesId() {
		return allergiesId;
	}
	public void setAllergiesId(int allergiesId) {
		this.allergiesId = allergiesId;
	}
	public String getAllergyName() {
		return allergyName;
	}
	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}
	
	public List<MedicalRecordAllergyUnit> getAllergyUnits() {
		return allergyUnits;
	}
	public void setAllergyUnits(List<MedicalRecordAllergyUnit> allergyUnits) {
		this.allergyUnits = allergyUnits;
	}
	@Override
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
	@Override
	public String getMedicalRecordId() {
		return medicalRecordId;
	}
	@Override
	public String getWriteQuery() {
		return "INSERT INTO allergies(allergies_id, medical_record_id, allergy_name) VALUES (?,?,?)";
	}
	@Override
	public String getWriteErrorMessage() {
		return "Could not add to allergies table!";
	}
	@Override
	public int prepareWriteStatement(PreparedStatement preparedStatement) throws SQLException {

		System.out.println("Adding to allergies table...");
		preparedStatement.setInt(1, getAllergiesId());
		preparedStatement.setString(2, getMedicalRecordId());
		preparedStatement.setString(3, getAllergyName());
		return preparedStatement.executeUpdate();
	}
}
