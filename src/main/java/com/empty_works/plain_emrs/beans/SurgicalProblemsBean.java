package com.empty_works.plain_emrs.beans;

import java.util.List;

import com.empty_works.plain_emrs.patient_choices.SurgicalProblemUnit;

public class SurgicalProblemsBean implements PatientIdInterface {

	private String userId;
	private String medicalRecordId;
	private List<SurgicalProblemUnit> surgeryMedProblems;

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

	public List<SurgicalProblemUnit> getSurgeryMedProblems() {
		return surgeryMedProblems;
	}

	public void setSurgeryMedProblems(List<SurgicalProblemUnit> surgeryMedProblems) {
		this.surgeryMedProblems = surgeryMedProblems;
	}
}
