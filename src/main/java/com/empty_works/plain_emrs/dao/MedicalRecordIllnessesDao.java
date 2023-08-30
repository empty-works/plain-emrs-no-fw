package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordIllnessesBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordIllnessesDao {

	public static List<MedicalRecordIllnessesBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordIllnessesBean> medicalRecordIllnessesList = new ArrayList<>();
		String query = "SELECT illness_id, chief_complaint_id, diagnosis_date, diagnosis_id, treatment_id, medication_id, "
				+ "surgical_related_id, allergy_id "
				+ "FROM illnesses "
				+ "WHERE medical_record_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				preparedStatement.setString(1, medicalRecordId);
				System.out.println("Retrieving from the illnesses table...");
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordIllnessesBean medicalRecordIllness = new MedicalRecordIllnessesBean();
					medicalRecordIllness.setIllnessId(rs.getInt("illness_id"));
					medicalRecordIllness.setMedicalRecordId(medicalRecordId);
					medicalRecordIllness.setChiefComplaintId(rs.getString("chief_complaint_id"));
					medicalRecordIllness.setDiagnosisDate(rs.getObject("diagnosis_date", LocalDateTime.class));
					medicalRecordIllness.setDiagnosisId(rs.getInt("diagnosis_id"));
					medicalRecordIllness.setTreatmentId(rs.getInt("treatment_id"));
					medicalRecordIllness.setMedicationId(rs.getInt("medication_id"));
					medicalRecordIllness.setSurgicalRelatedId(rs.getInt("surgical_related_id"));
					medicalRecordIllness.setAllergyId(rs.getInt("allergy_id"));
					medicalRecordIllnessesList.add(medicalRecordIllness);
				}
			}
		}
		return medicalRecordIllnessesList;
	}
	
	public static int add(MedicalRecordIllnessesBean medRecordIllnessesBean) throws SQLException {
		String query = "INSERT INTO illnesses(medical_record_id, chief_complaint_id, diagnosis_date, diagnosis_id, treatment_id, medication_id, "
				+ "surgical_related_id, allergy_id) VALUES (?,?,?,?,?,?,?,?)";
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				System.out.println("Writing to the illnesses table...");
				preparedStatement.setString(1, medRecordIllnessesBean.getMedicalRecordId());
				preparedStatement.setString(2, medRecordIllnessesBean.getChiefComplaintId());
				preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(medRecordIllnessesBean.getDiagnosisDate()));
				preparedStatement.setInt(4, medRecordIllnessesBean.getDiagnosisId());
				preparedStatement.setInt(5, medRecordIllnessesBean.getTreatmentId());
				preparedStatement.setInt(6, medRecordIllnessesBean.getMedicationId());
				preparedStatement.setInt(7, medRecordIllnessesBean.getSurgicalRelatedId());
				preparedStatement.setInt(8, medRecordIllnessesBean.getAllergyId());
				success = preparedStatement.executeUpdate();
			}
		}
		return success;
	}
}
