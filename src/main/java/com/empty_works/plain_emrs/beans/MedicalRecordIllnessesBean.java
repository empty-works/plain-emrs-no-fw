package com.empty_works.plain_emrs.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MedicalRecordIllnessesBean implements MedicalRecordInterface, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4400930315372872571L;
	private int illnessId;
	private String medicalRecordId;
	private String chiefComplaintId;
	private LocalDateTime diagnosisDate;
	private int diagnosisId;
	private int treatmentId;
	private int medicationId;
	private int surgicalRelatedId;
	private int allergyId;

	@Override
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	@Override
	public String getMedicalRecordId() {
		return medicalRecordId;
	}

	public int getIllnessId() {
		return illnessId;
	}

	public void setIllnessId(int illnessId) {
		this.illnessId = illnessId;
	}

	public String getChiefComplaintId() {
		return chiefComplaintId;
	}

	public void setChiefComplaintId(String chiefComplaintId) {
		this.chiefComplaintId = chiefComplaintId;
	}

	public LocalDateTime getDiagnosisDate() {
		return diagnosisDate;
	}

	public void setDiagnosisDate(LocalDateTime diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	public int getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(int diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public int getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(int treatmentId) {
		this.treatmentId = treatmentId;
	}

	public int getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(int medicationId) {
		this.medicationId = medicationId;
	}

	public int getSurgicalRelatedId() {
		return surgicalRelatedId;
	}

	public void setSurgicalRelatedId(int surgicalRelatedId) {
		this.surgicalRelatedId = surgicalRelatedId;
	}

	public int getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(int allergyId) {
		this.allergyId = allergyId;
	}
}
