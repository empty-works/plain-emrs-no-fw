package com.empty_works.plain_emrs.patient_choices;

public class PatientFamilyConditionUnit {

	private String familyConditionId;
	private String familyCondition;
	
	public PatientFamilyConditionUnit(String familyConditionId, String familyCondition) {
		
		this.familyConditionId = familyConditionId;
		this.familyCondition = familyCondition;
	}

	public String getFamilyConditionId() {
		return familyConditionId;
	}

	public String getFamilyCondition() {
		return familyCondition;
	}
}
