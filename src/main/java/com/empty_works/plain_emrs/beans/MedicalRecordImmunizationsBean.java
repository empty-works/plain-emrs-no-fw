package com.empty_works.plain_emrs.beans;

import java.io.Serializable;
import java.util.List;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseUnit;

public class MedicalRecordImmunizationsBean implements MedicalRecordInterface, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1669984925218648995L;
	private int immunizationId;
	private String immunization;
	private String medicalRecordId;
	
	public int getImmunizationId() {
		return immunizationId;
	}
	public void setImmunizationId(int immunizationId) {
		this.immunizationId = immunizationId;
	}
	public String getImmunization() {
		return immunization;
	}
	public void setImmunization(String immunization) {
		this.immunization = immunization;
	}
	public String getMedicalRecordId() {
		return medicalRecordId;
	}
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
}