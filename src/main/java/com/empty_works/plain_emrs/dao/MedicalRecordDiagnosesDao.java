package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordDiagnosesBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordDiagnosesDao {

	/**
	 * 
	 * @param medicalRecordId
	 * @return
	 * @throws SQLException
	 */
	public static List<MedicalRecordDiagnosesBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordDiagnosesBean> diagnoses = new ArrayList<>();
		
		String query = "SELECT diagnosis_id, chief_complaint_id, diagnosis_title, diagnosis_date, diagnosis_description "
				+ "FROM diagnoses "
				+ "WHERE medical_record_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					
					MedicalRecordDiagnosesBean diagnosis = new MedicalRecordDiagnosesBean();
					diagnosis.setDiagnosisId(rs.getInt("diagnosis_id"));
					diagnosis.setChiefComplaintId(rs.getInt("chief_complaint_id"));
					diagnosis.setDiagnosisTitle(rs.getString("diagnosis_title"));
					diagnosis.setDiagnosisDate(rs.getObject("diagnosis_date", LocalDateTime.class));
					diagnosis.setDiagnosisDescription(rs.getString("diagnosis_description"));
					diagnoses.add(diagnosis);
				}
			}
		}
		return diagnoses;
	}
	
	public static String add(MedicalRecordDiagnosesBean diagnosis) throws SQLException {
		
		String query = "INSERT INTO diagnoses(chief_complaint_id, medical_record_id, diagnosis_title, diagnosis_date, diagnosis_description) "
				+ "VALUES (?,?,?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setInt(1, diagnosis.getChiefComplaintId());
				preparedStatement.setString(2, diagnosis.getMedicalRecordId());
				preparedStatement.setString(3, diagnosis.getDiagnosisTitle());
				preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(diagnosis.getDiagnosisDate()));
				preparedStatement.setString(5, diagnosis.getDiagnosisDescription());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add to the diagnoses table!";
		}
		return "Successfully added to the diagnoses table!";
	}
}
