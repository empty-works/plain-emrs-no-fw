package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicalRecordAllergiesBean implements MedicalRecordInterface, BeanDaoInterface {

	private int allergies;
	private String medicalRecordId;
	private String allergyName;
	
	public int getAllergies() {
		return allergies;
	}
	public void setAllergies(int allergies) {
		this.allergies = allergies;
	}
	public String getAllergyName() {
		return allergyName;
	}
	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}
	@Override
	public String getWriteQuery() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int prepareStatments(PreparedStatement preparedStatement) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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
