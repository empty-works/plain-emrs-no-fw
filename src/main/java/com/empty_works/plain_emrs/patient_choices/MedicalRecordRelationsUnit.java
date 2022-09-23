package com.empty_works.plain_emrs.patient_choices;

public class MedicalRecordRelationsUnit {

	private String relation;
	private int numRelations;
	
	public MedicalRecordRelationsUnit(String relation, int numRelations) {
		
		this.relation = relation;
		this.numRelations = numRelations;
	}

	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public int getNumRelations() {
		return numRelations;
	}
	public void setNumRelations(int numRelations) {
		this.numRelations = numRelations;
	}
}