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
	
	public static String add(MedicalRecordSurgicalProblemsBean medRecordSurgicalProblemsBean) throws SQLException {
		
		String query = "INSERT INTO surgical_related_problems(medical_record_id, surgical_related_problem, problem_area, "
				+ "surgical_procedure, surgical_procedure_year) values (?,?,?,?,?)";

		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				System.out.println("Adding to surgical_related_problems...");
				preparedStatement.setString(1, medRecordSurgicalProblemsBean.getMedicalRecordId());
				preparedStatement.setString(2, medRecordSurgicalProblemsBean.getSurgicalRelatedProblem());
				preparedStatement.setString(3, medRecordSurgicalProblemsBean.getProblemArea());
				preparedStatement.setString(4, medRecordSurgicalProblemsBean.getSurgicalProcedure());
				preparedStatement.setString(5, medRecordSurgicalProblemsBean.getSurgicalProcedureYear());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add surgical problems to the database!";
		}
		return "Successfully added surgical problems to the database!";
	}
}
