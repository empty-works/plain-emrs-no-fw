package com.empty_works.plain_emrs.beans;

public class MedicalRecordMedicationBean implements MedicalRecordInterface {

	private int medicationId;
	private String medicalRecordId;
	private String medicationName;
	private boolean medicationIsCurrent;
	private String medicationDescription;

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
}
