package com.empty_works.plain_emrs.patient_choices;

public class PatientFamilyConditionUnit {

	private String familyConditionId;
	private String familyCondition;
	private String familyRelation;
	
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

	public String getFamilyRelation() {
		return familyRelation;
	}

	public void setFamilyRelation(String familyRelation) {
		this.familyRelation = familyRelation;
	}
}
