package com.empty_works.plain_emrs.beans.medical_record;

import java.time.LocalDateTime;

public class PatientMedicalRecordBean {

	protected int medicalRecordId;
	protected String userId;
	private String patientCondition;
	private LocalDateTime dateCreated;
	private boolean isActive;
	private String bloodTransfusionStatus;

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
	public String getPatientCondition() {
		return patientCondition;
	}
	public void setPatientCondition(String patientCondition) {
		this.patientCondition = patientCondition;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getBloodTransfusionStatus() {
		return bloodTransfusionStatus;
	}
	public void setBloodTransfusionStatus(String bloodTransfusionStatus) {
		this.bloodTransfusionStatus = bloodTransfusionStatus;
	}
}
