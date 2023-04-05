package com.empty_works.plain_emrs.beans;

import java.util.List;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordAllergyUnit;

public class MedicalRecordAllergiesBean implements MedicalRecordInterface {

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
}
