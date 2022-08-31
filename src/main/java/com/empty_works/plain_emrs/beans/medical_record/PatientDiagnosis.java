package com.empty_works.plain_emrs.beans.medical_record;

import java.time.LocalDateTime;

public class PatientDiagnosis {

	private String diagnosisId;
	private int medicalRecordId;
	private String userId;
	private String diagnosisTitle;
	private LocalDateTime diagnosisDate;
	private String diagnosisDescription;

	public String getDiagnosisId() {
		return diagnosisId;
	}
	public void setDiagnosisId(String diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	public int getMedicalRecordId() {
		return medicalRecordId;
	}
	public void setMedicalRecordId(int medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDiagnosisTitle() {
		return diagnosisTitle;
	}
	public void setDiagnosisTitle(String diagnosisTitle) {
		this.diagnosisTitle = diagnosisTitle;
	}
	public LocalDateTime getDiagnosisDate() {
		return diagnosisDate;
	}
	public void setDiagnosisDate(LocalDateTime diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}
	public String getDiagnosisDescription() {
		return diagnosisDescription;
	}
	public void setDiagnosisDescription(String diagnosisDescription) {
		this.diagnosisDescription = diagnosisDescription;
	}
}
