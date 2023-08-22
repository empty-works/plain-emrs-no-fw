package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordMedicationBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordMedicationDao {

	public static List<MedicalRecordMedicationBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordMedicationBean> medRecordMedicationBeanList = new ArrayList<>();
		String query = "SELECT medication_id, chief_complaint_id, medication_name, medication_is_current, medication_description, frequency,"
				+ "dosage, start_date, end_date, healthcare_provider "
				+ "FROM medications "
				+ "WHERE medical_record_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				System.out.println("Retrieving from the medication table...");
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordMedicationBean medRecordMedicationBean = new MedicalRecordMedicationBean();
					medRecordMedicationBean.setChiefComplaintId(rs.getString("chief_complaint_id"));;
					medRecordMedicationBean.setMedicationId(rs.getInt("medication_id"));
					medRecordMedicationBean.setMedicationName(rs.getString("medication_name"));
					medRecordMedicationBean.setMedicationIsCurrent(rs.getBoolean("medication_is_current"));
					medRecordMedicationBean.setMedicationDescription(rs.getString("medication_description"));
					medRecordMedicationBean.setFrequency(rs.getString("frequency"));
					medRecordMedicationBean.setDosage(rs.getDouble("dosage"));
					medRecordMedicationBean.setStartDate(rs.getObject("start_date", LocalDateTime.class));
					medRecordMedicationBean.setEndDate(rs.getObject("end_date", LocalDateTime.class));
					medRecordMedicationBean.setHealthcareProvider(rs.getString("healthcare_provider"));
					medRecordMedicationBeanList.add(medRecordMedicationBean);
				}
			}
		}
		return medRecordMedicationBeanList;
	}
	
	public static String add(MedicalRecordMedicationBean medRecordMedicationBean) throws SQLException {
		
		// medication_id is auto-incremented.
		String query = "INSERT INTO medication(medical_record_id, medication_name, medication_is_current, medication_description) "
				+ "VALUES (?,?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medRecordMedicationBean.getMedicalRecordId());
				preparedStatement.setString(2, medRecordMedicationBean.getMedicationName());
				preparedStatement.setBoolean(3, medRecordMedicationBean.isMedicationCurrent());
				preparedStatement.setString(4, medRecordMedicationBean.getMedicationDescription());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add patient medication to the database!";
		}
		return "Successfully added patient medication to the database!";
	}
}
