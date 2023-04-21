package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordSurgicalProblemsBean;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordSurgicalProblemUnit;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordSurgicalProblemsDao {

	public static String SURGICALDAO_SUCCESS = "Surgical problem data successfully added.";

	public static List<MedicalRecordSurgicalProblemsBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordSurgicalProblemsBean> medRecordSurgicalProblemsBeanList = new ArrayList<>();
		String query = "SELECT surgical_related_id, surgical_related_problem, problem_area, surgical_procedure, surgical_procedure_year "
				+ "FROM surgical_related_problems "
				+ "WHERE medical_record_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				System.out.println("Retrieving from the surgical_related_problems table...");
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordSurgicalProblemsBean medRecordSurgicalProblemsBean = new MedicalRecordSurgicalProblemsBean();
					medRecordSurgicalProblemsBean.setSurgicalRelatedId(rs.getInt("surgical_related_id"));
					medRecordSurgicalProblemsBean.setSurgicalRelatedProblem(rs.getString("surgical_related_problem"));
					medRecordSurgicalProblemsBean.setProblemArea(rs.getString("problem_area"));
					medRecordSurgicalProblemsBean.setSurgicalProcedure(rs.getString("surgical_procedure"));
					medRecordSurgicalProblemsBean.setSurgicalProcedureYear(rs.getString("surgical_procedure_year"));
					medRecordSurgicalProblemsBeanList.add(medRecordSurgicalProblemsBean);
				}
			}
		}
		return medRecordSurgicalProblemsBeanList;
	}
	
	public static String add(MedicalRecordSurgicalProblemsBean medRecordSurgicalProblemsBean) throws SQLException {
		
		String query = "INSERT INTO surgical_related_problems(medical_record_id, surgical_related_problem, problem_area, "
				+ "surgical_procedure, surgical_procedure_year) values (?,?,?,?,?)";

		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				List<MedicalRecordSurgicalProblemUnit> surgicalUnits = medRecordSurgicalProblemsBean.getSurgicalRelatedProblems();
				if(surgicalUnits != null && surgicalUnits.size() > 0) {
					for(MedicalRecordSurgicalProblemUnit surgicalUnit : surgicalUnits) {
						System.out.println("Adding to surgical_related_problems...");
						preparedStatement.setString(1, medRecordSurgicalProblemsBean.getMedicalRecordId());
						preparedStatement.setString(2, surgicalUnit.getSurgicalRelatedProblem());
						preparedStatement.setString(3, surgicalUnit.getProblemArea());
						preparedStatement.setString(4, surgicalUnit.getSurgicalProcedure());
						preparedStatement.setString(5, surgicalUnit.getSurgicalProcedureYear());
						preparedStatement.addBatch();
					}
					success = preparedStatement.executeBatch()[0];
				}
			}
		}
		if(success == 0) {
			return "Could not add surgical problems to the database!";
		}
		return "Successfully added surgical problems to the database!";
	}
}
