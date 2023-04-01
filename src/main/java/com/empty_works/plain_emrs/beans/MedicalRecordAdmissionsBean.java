package com.empty_works.plain_emrs.beans;

import java.time.LocalDateTime;

public class MedicalRecordAdmissionsBean implements MedicalRecordInterface {

	private int admissionId;
	private String medicalRecordId;
	private LocalDateTime dateOfAdmission;
	private String description;
	
	public int getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(int admissionId) {
		this.admissionId = admissionId;
	}

	public LocalDateTime getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(LocalDateTime dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
