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
				medRecordSurgicalProblemsBean.set
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
