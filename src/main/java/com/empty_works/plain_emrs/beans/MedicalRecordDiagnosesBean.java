package com.empty_works.plain_emrs.beans;

import java.time.LocalDateTime;

public class MedicalRecordDiagnosesBean implements MedicalRecordInterface {

	private int diagnosisId;
	private int chiefComplaintId;
	private String medicalRecordId;
	private String diagnosisTitle;
	private LocalDateTime diagnosisDate;
	private String diagnosisDescription;
	
	public int getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(int diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public int getChiefComplaintId() {
		return chiefComplaintId;
	}

	public void setChiefComplaintId(int chiefComplaintId) {
		this.chiefComplaintId = chiefComplaintId;
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

	@Override
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	@Override
	public String getMedicalRecordId() {
		return medicalRecordId;
	}
}
