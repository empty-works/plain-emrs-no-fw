package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.SurgicalProblemsBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class SurgicalProblemsDao {

	public static String SURGICALDAO_SUCCESS = "Surgical problem data successfully added.";
	
	public static String add(SurgicalProblemsBean surgery) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "INSERT INTO surgical_related_problems(medical_record_id, surgical_related_problem, problem_area, "
				+ "surgical_procedure, surgical_procedure_year) values (?,?,?,?,?)";
		
		try {
			preparedStatement = con.prepareStatement(query);
			for(int i = 0; i < surgery.getSurgeryMedProblems().size(); i++) {
				
				preparedStatement.setString(1, surgery.getMedicalRecordId());
				preparedStatement.setString(2, surgery.getSurgeryMedProblems().get(i).getSurgicalRelatedProblem());
				preparedStatement.setString(3, surgery.getSurgeryMedProblems().get(i).getProblemArea());
				preparedStatement.setString(4, surgery.getSurgeryMedProblems().get(i).getSurgicalProcedure());
				preparedStatement.setString(5, surgery.getSurgeryMedProblems().get(i).getSurgicalProcedureYear());
				preparedStatement.addBatch();
			}
			int[] checks = preparedStatement.executeBatch();
			for(int check : checks) {
				// If even one returns zero, insertion failed.
				if(check == 0) {return "Something went wrong. Could not add surgery-related problem data.";}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SURGICALDAO_SUCCESS;
	}
}
