package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordAdmissionsBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordAdmissionsDao {

	/**
	 * 
	 * @param medicalRecordId
	 * @return
	 * @throws SQLException
	 */
	public static List<MedicalRecordAdmissionsBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordAdmissionsBean> admissions = new ArrayList<>();
		
		String query = "SELECT admission_id, date_of_admission, description "
				+ "FROM admissions "
				+ "WHERE medical_record_id=?";
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				System.out.println("Retrieving from the admissions table...");
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordAdmissionsBean admission = new MedicalRecordAdmissionsBean();
					admission.setAdmissionId(rs.getInt("admission_id"));
					admission.setDateOfAdmission(rs.getObject("date_of_admission", LocalDateTime.class));
					admission.setDescription(rs.getString("description"));
					admissions.add(admission);
				}
			}
		}
		return admissions;
	}
	
	/**
	 * 
	 * @param admission
	 * @return
	 * @throws SQLException
	 */
	public static String add(MedicalRecordAdmissionsBean admission) throws SQLException {
		
		String query = "INSERT INTO admissions(medical_record_id, date_of_admission, description) "
				+ "VALUES (?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, admission.getMedicalRecordId());
				preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf(admission.getDateOfAdmission()));
				preparedStatement.setString(3, admission.getDescription());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add to the admissions table!";
		}
		return "Successfully added to the admissions table!";
	}
}
