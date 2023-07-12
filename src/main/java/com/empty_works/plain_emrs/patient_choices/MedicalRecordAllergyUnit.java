package com.empty_works.plain_emrs.patient_choices;

public class MedicalRecordAllergyUnit {

	private String allergyName;
	private String allergySeverity;
	private String additionalInformation;
	
	public MedicalRecordAllergyUnit(String allergyName) {
		
		this.allergyName = allergyName;
	}

	public String getAllergyName() {
		
		return allergyName;
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
}
