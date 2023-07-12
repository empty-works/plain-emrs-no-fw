package com.empty_works.plain_emrs.beans;

import java.util.List;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordAllergyUnit;

public class MedicalRecordAllergiesBean implements MedicalRecordInterface, java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3425989602412918530L;
	private String medicalRecordId;
	private String allergiesId;
	private String allergyName;
	private String allergySeverity;
	private String additionalInformation;
	
	private List<MedicalRecordAllergyUnit> allergyUnits;
	
	public String getAllergyId() {
		return allergiesId;
	}
	public void setAllergyId(String allergiesId) {
		this.allergiesId = allergiesId;
	}
	public String getAllergyName() {
		return allergyName;
	}
	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}
	
	public String getAllergySeverity() {
		return allergySeverity;
	}
	public void setAllergySeverity(String allergySeverity) {
		this.allergySeverity = allergySeverity;
	}
	public String getAdditionalInformation() {
		return additionalInformation;
	}
	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}
	public List<MedicalRecordAllergyUnit> getAllergyUnits() {
		return allergyUnits;
	}
	public void setAllergyUnits(List<MedicalRecordAllergyUnit> allergyUnits) {
		this.allergyUnits = allergyUnits;
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
