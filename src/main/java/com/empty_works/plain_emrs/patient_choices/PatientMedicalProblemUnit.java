package com.empty_works.plain_emrs.patient_choices;

public class PatientMedicalProblemUnit {

	private String problemAreaId;
	private String problemArea;
	
	public PatientMedicalProblemUnit(String problemAreaId, String problemArea) {
		
		this.problemAreaId = problemAreaId;
		this.problemArea = problemArea;
	}

	public String getProblemAreaId() {
		return problemAreaId;
	}
	public String getProblemArea() {
		return problemArea;
	}
}
