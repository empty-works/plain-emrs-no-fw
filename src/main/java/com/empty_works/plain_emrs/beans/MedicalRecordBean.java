package com.empty_works.plain_emrs.beans;

import java.time.LocalDateTime;

import com.empty_works.plain_emrs.patient_choices.PatientIllnessUnit;

public class MedicalRecordBean extends UserBean {

	// User ID in parent class
	private String patientCondition;
	private LocalDateTime medicalRecordCreatedOn;
	private boolean isActive;
	private String bloodTransfusionStatus;

	public String getPatientCondition() {
		return patientCondition;
	}
	public void setPatientCondition(String patientCondition) {
		this.patientCondition = patientCondition;
	}
	public LocalDateTime getMedicalRecordCreatedOn() {
		return medicalRecordCreatedOn;
	}
	public void setMedicalRecordCreatedOn(LocalDateTime medicalRecordCreatedOn) {
		this.medicalRecordCreatedOn = medicalRecordCreatedOn;
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