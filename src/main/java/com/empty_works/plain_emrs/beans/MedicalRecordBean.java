package com.empty_works.plain_emrs.beans;

import java.time.LocalDateTime;
import java.util.List;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseUnit;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordRelationsUnit;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordSurgeryUnit;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordFamilyIllnessUnit;
import com.empty_works.plain_emrs.patient_choices.PatientIllnessUnit;

public class MedicalRecordBean implements PatientIdInterface {

	private String userId;
	private String medicalRecordId;
	private String patientCondition;
	private LocalDateTime medicalRecordCreatedOn;
	private boolean isActive;
	private String bloodTransfusionStatus;

	@Override
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String getUserId() {
		return userId;
	}
	public String getMedicalRecordId() {
		return medicalRecordId;
	}
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
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
