package com.empty_works.plain_emrs.patient_choices;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordFamilyIllnessUnit {

	public static String FATHER = "Father";
	public static String MOTHER = "Mother";
	public static String BROTHERS = "Brothers";
	public static String SISTERS = "Sisters";
	public static String SONS = "Sons";
	public static String DAUGHTERS = "Daughters";
	public static String GRANDPARENTS = "Grandparents";
	private String familyConditionId;
	private String familyCondition;
	private List<Boolean> familyRelations = new ArrayList<>();
	
	public MedicalRecordFamilyIllnessUnit(String familyIllnessId, String familyIllness) {
		
		this.familyConditionId = familyIllnessId;
		this.familyCondition = familyIllness;
	}

	public String getFamilyIllnessId() {
		return familyConditionId;
	}

	public String getFamilyIllness() {
		return familyCondition;
	}

	public List<Boolean> getFamilyRelations() {
		return familyRelations;
	}

	public void setFamilyRelation(Boolean relation) {
		this.familyRelations.add(relation);
	}
}
