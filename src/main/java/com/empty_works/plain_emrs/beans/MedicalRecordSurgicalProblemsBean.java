package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.empty_works.plain_emrs.patient_choices.SurgicalProblemUnit;

public class MedicalRecordSurgicalProblemsBean implements MedicalRecordInterface, BeanDaoInterface {

	private int surgicalRelatedId;
	private String medicalRecordId;
	private String surgicalRelatedProblem;
	private List<SurgicalProblemUnit> surgicalRelatedProblems;
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
	public List<SurgicalProblemUnit> getSurgicalRelatedProblems() {
		return surgicalRelatedProblems;
	}

	public void setSurgicalRelatedProblems(List<SurgicalProblemUnit> surgicalRelatedProblems) {
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

	@Override
	public String getWriteQuery() {
		return "INSERT INTO surgical_related_problems(medical_record_id, surgical_related_problem, problem_area, "
				+ "surgical_procedure, surgical_procedure_year) values (?,?,?,?,?)";
	}

	@Override
	public String getWriteErrorMessage() {
		return "Could not add surgical procedures data!";
	}

	@Override
	public int prepareWriteStatement(PreparedStatement preparedStatement) throws SQLException {

		System.out.println("Adding to surgical_related_problems...");
		preparedStatement.setString(1, getMedicalRecordId());
		preparedStatement.setString(2, getSurgicalRelatedProblem());
		preparedStatement.setString(3, getProblemArea());
		preparedStatement.setString(4, getSurgicalProcedure());
		preparedStatement.setString(5, getSurgicalProcedureYear());
		return preparedStatement.executeUpdate();
	}
}
