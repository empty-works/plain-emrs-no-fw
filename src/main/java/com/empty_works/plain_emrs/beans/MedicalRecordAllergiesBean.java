package com.empty_works.plain_emrs.beans;

public class MedicalRecordAllergiesBean implements MedicalRecordInterface {

	private int allergiesId;
	private String medicalRecordId;
	private String allergyName;
	
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

	@Override
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
	@Override
	public String getMedicalRecordId() {
		return medicalRecordId;
	}
}
