package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordAssessmentsBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordAssessmentsDao {

	public static List<MedicalRecordAssessmentsBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordAssessmentsBean> assessments = new ArrayList<>();
		String query = "SELECT assessment_id, chief_complaint_id, summation "
				+ "FROM assessments "
				+ "WHERE medical_record_id=?";
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordAssessmentsBean assessment = new MedicalRecordAssessmentsBean();
					assessment.setAssessmentId(rs.getInt("assessment_id"));
					assessment.setChiefComplaintId(rs.getInt("chief_complaint_id"));
					assessment.setSummation(rs.getString("summation"));
					assessments.add(assessment);
				}
			}
		}
		return assessments;
	}
	
	public static String add(MedicalRecordAssessmentsBean assessment) throws SQLException {
		
		String query = "INSERT INTO assessments(chief_complaint_id, medical_record_id, summation) "
				+ "VALUES (?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setInt(1, assessment.getChiefComplaintId());
				preparedStatement.setString(2, assessment.getMedicalRecordId());
				preparedStatement.setString(3, assessment.getSummation());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add to the assessments table!";
		}
		return "Successfully added to the assessments table!";
	}
}
