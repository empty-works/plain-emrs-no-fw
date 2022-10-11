package com.empty_works.plain_emrs.beans;

import java.util.List;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseUnit;

public class DiseasesBean implements PatientIdInterface {

	private String userId;
	private String medicalRecordId;
	private List<MedicalRecordDiseaseUnit> diseases;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMedicalRecordId() {
		return medicalRecordId;
	}
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
	public List<MedicalRecordDiseaseUnit> getDiseases() {
		return diseases;
	}
	public void setDiseases(List<MedicalRecordDiseaseUnit> diseases) {
		this.diseases = diseases;
	}
}