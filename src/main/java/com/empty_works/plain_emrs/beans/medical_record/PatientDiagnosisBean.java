package com.empty_works.plain_emrs.beans.medical_record;

import java.time.LocalDateTime;

public class PatientDiagnosisBean extends PatientMedicalRecordBean {

	// User ID and medical record ID in parent class
	private String diagnosisId;
	private String diagnosisTitle;
	private LocalDateTime diagnosisDate;
	private String diagnosisDescription;

	public String getDiagnosisId() {
		return diagnosisId;
	}
	public void setDiagnosisId(String diagnosisId) {
		this.diagnosisId = diagnosisId;
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
