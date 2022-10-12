package com.empty_works.plain_emrs.beans;

import java.util.List;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordSurgeryUnit;

public class SurgicalProblemsBean implements PatientIdInterface {

	private String userId;
	private String medicalRecordId;
	private List<MedicalRecordSurgeryUnit> surgeryMedProblems;

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

	public List<MedicalRecordSurgeryUnit> getSurgeryMedProblems() {
		return surgeryMedProblems;
	}

	public void setSurgeryMedProblems(List<MedicalRecordSurgeryUnit> surgeryMedProblems) {
		this.surgeryMedProblems = surgeryMedProblems;
	}
}
