package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.empty_works.plain_emrs.patient_choices.SurgicalProblemUnit;

public class SurgicalProblemsBean implements PatientIdInterface, BeanDaoInterface {

	private String userId;
	private String medicalRecordId;
	private List<SurgicalProblemUnit> surgeryMedProblems;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMedicalRecordId() {
		return medicalRecordId;
	}

	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	public List<SurgicalProblemUnit> getSurgeryMedProblems() {
		return surgeryMedProblems;
	}

	public void setSurgeryMedProblems(List<SurgicalProblemUnit> surgeryMedProblems) {
		this.surgeryMedProblems = surgeryMedProblems;
	}

	@Override
	public String getWriteQuery() {
		return "INSERT INTO surgical_related_problems(medical_record_id, surgical_related_problem, problem_area, "
				+ "surgical_procedure, surgical_procedure_year) values (?,?,?,?,?)";
	}

	@Override
	public String getErrorMessage() {
		return "Could not add surgical procedures data!";
	}

	@Override
	public int prepareStatments(PreparedStatement preparedStatement) throws SQLException {

		if(surgeryMedProblems != null && surgeryMedProblems.size() > 0) {
			for(int i = 0; i < surgeryMedProblems.size(); i++) {
				preparedStatement.setString(1, getMedicalRecordId());
				preparedStatement.setString(2, getSurgeryMedProblems().get(i).getSurgicalRelatedProblem());
				preparedStatement.setString(3, getSurgeryMedProblems().get(i).getProblemArea());
				preparedStatement.setString(4, getSurgeryMedProblems().get(i).getSurgicalProcedure());
				preparedStatement.setString(5, getSurgeryMedProblems().get(i).getSurgicalProcedureYear());
				preparedStatement.addBatch();
			}
			return preparedStatement.executeBatch()[0];
		}
		return 0;
	}
}
