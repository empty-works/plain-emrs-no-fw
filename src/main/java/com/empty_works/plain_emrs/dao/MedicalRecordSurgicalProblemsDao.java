package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordSurgicalProblemsBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordSurgicalProblemsDao {

	public static String SURGICALDAO_SUCCESS = "Surgical problem data successfully added.";

	public static List<MedicalRecordSurgicalProblemsBean> get(String medicalRecordId) {
		
		List<MedicalRecordSurgicalProblemsBean> medRecordSurgicalProblemsBeanList = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "SELECT surgical_related_id, surgical_related_problem, problem_area, surgical_procedure, surgical_procedure_year "
				+ "FROM surgical_related_problems "
				+ "WHERE medical_record_id=?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, medicalRecordId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				MedicalRecordSurgicalProblemsBean medRecordSurgicalProblemsBean = new MedicalRecordSurgicalProblemsBean();
				medRecordSurgicalProblemsBean.getSurgicalRelatedId();
				medRecordSurgicalProblemsBean.getSurgicalRelatedProblem();
				medRecordSurgicalProblemsBean.getProblemArea();
				medRecordSurgicalProblemsBean.getSurgicalProcedure();
				medRecordSurgicalProblemsBean.getSurgicalProcedureYear();
				medRecordSurgicalProblemsBeanList.add(medRecordSurgicalProblemsBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return medRecordSurgicalProblemsBeanList;
	}
	
	public static String get(MedicalRecordSurgicalProblemsBean medRecordSurgicalProblemsBean) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "INSERT INTO surgical_related_problems(medical_record_id, surgical_related_problem, problem_area, "
				+ "surgical_procedure, surgical_procedure_year) values (?,?,?,?,?)";

		try {
			preparedStatement = con.prepareStatement(query);
			for(int i = 0; i < medRecordSurgicalProblemsBean.getSurgicalRelatedProblems().size(); i++) {
				
				preparedStatement.setString(1, medRecordSurgicalProblemsBean.getMedicalRecordId());
				preparedStatement.setString(2, medRecordSurgicalProblemsBean.getSurgicalRelatedProblems().get(i).getSurgicalRelatedProblem());
				preparedStatement.setString(3, medRecordSurgicalProblemsBean.getSurgicalRelatedProblems().get(i).getProblemArea());
				preparedStatement.setString(4, medRecordSurgicalProblemsBean.getSurgicalRelatedProblems().get(i).getSurgicalProcedure());
				preparedStatement.setString(5, medRecordSurgicalProblemsBean.getSurgicalRelatedProblems().get(i).getSurgicalProcedureYear());
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
