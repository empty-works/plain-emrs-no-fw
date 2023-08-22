package com.empty_works.plain_emrs.beans;

import java.time.LocalDateTime;

public class MedicalRecordMedicationBean implements MedicalRecordInterface {

	private String chiefComplaintId;
	private int medicationId;
	private String medicalRecordId;
	private String medicationName;
	private boolean medicationIsCurrent;
	private String medicationDescription;
	private String frequency;
	private double dosage;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String healthcareProvider;
	
	public String getChiefComplaintId() {
		return chiefComplaintId;
	}

	public void setChiefComplaintId(String chiefComplaintId) {
		this.chiefComplaintId = chiefComplaintId;
	}

	public int getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(int medicationId) {
		this.medicationId = medicationId;
	}

	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	public boolean isMedicationCurrent() {
		return medicationIsCurrent;
	}

	public void setMedicationIsCurrent(boolean medicationIsCurrent) {
		this.medicationIsCurrent = medicationIsCurrent;
	}

	public String getMedicationDescription() {
		return medicationDescription;
	}

	public void setMedicationDescription(String medicationDescription) {
		this.medicationDescription = medicationDescription;
	}

	@Override
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	@Override
	public String getMedicalRecordId() {
		return medicalRecordId;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public double getDosage() {
		return dosage;
	}

	public void setDosage(double dosage) {
		this.dosage = dosage;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getHealthcareProvider() {
		return healthcareProvider;
	}

	public void setHealthcareProvider(String healthcareProvider) {
		this.healthcareProvider = healthcareProvider;
	}
}
