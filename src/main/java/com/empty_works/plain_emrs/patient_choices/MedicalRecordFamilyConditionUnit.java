package com.empty_works.plain_emrs.patient_choices;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordFamilyConditionUnit {

	public static String SELF = "self";
	private String familyConditionId;
	private String familyCondition;
	private List<String> familyRelations = new ArrayList<>();
	
	public MedicalRecordFamilyConditionUnit(String familyConditionId, String familyCondition) {
		
		this.familyConditionId = familyConditionId;
		this.familyCondition = familyCondition;
	}

	public String getFamilyConditionId() {
		return familyConditionId;
	}

	public String getFamilyCondition() {
		return familyCondition;
	}

	public List<String> getFamilyRelations() {
		return familyRelations;
	}

	public void setFamilyRelation(String relation) {
		this.familyRelations.add(relation);
	}
}
