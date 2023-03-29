package com.empty_works.plain_emrs.beans;

import java.util.List;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordSurgicalProblemUnit;

public class MedicalRecordSurgicalProblemsBean implements MedicalRecordInterface {

	private int surgicalRelatedId;
	private String medicalRecordId;
	private String surgicalRelatedProblem;
	private List<MedicalRecordSurgicalProblemUnit> surgicalRelatedProblems;
	private String problemArea;
	private String surgicalProcedure;
	private String surgicalProcedureYear;

	public int getSurgicalRelatedId() {
		return surgicalRelatedId;
	}

	public void setSurgicalRelatedId(int surgicalRelatedId) {
		this.surgicalRelatedId = surgicalRelatedId;
	}

	public String getSurgicalRelatedProblem() {
		return surgicalRelatedProblem;
	}

	public void setSurgicalRelatedProblem(String surgicalRelatedProblem) {
		this.surgicalRelatedProblem = surgicalRelatedProblem;
	}
	public List<MedicalRecordSurgicalProblemUnit> getSurgicalRelatedProblems() {
		return surgicalRelatedProblems;
	}

	public void setSurgicalRelatedProblems(List<MedicalRecordSurgicalProblemUnit> surgicalRelatedProblems) {
		this.surgicalRelatedProblems = surgicalRelatedProblems;
	}

	public String getProblemArea() {
		return problemArea;
	}

	public void setProblemArea(String problemArea) {
		this.problemArea = problemArea;
	}

	public String getSurgicalProcedure() {
		return surgicalProcedure;
	}

	public void setSurgicalProcedure(String surgicalProcedure) {
		this.surgicalProcedure = surgicalProcedure;
	}

	public String getSurgicalProcedureYear() {
		return surgicalProcedureYear;
	}

	public void setSurgicalProcedureYear(String surgicalProcedureYear) {
		this.surgicalProcedureYear = surgicalProcedureYear;
	}

	public String getMedicalRecordId() {
		return medicalRecordId;
	}

	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
}
