package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import com.empty_works.plain_emrs.beans.MedicalRecordBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordDao {

	final public static String MEDICALRECORDDAO_SUCCESS = "Successfully added to medical record!";
	
	public static MedicalRecordBean get(String userPatientId) {
		
		MedicalRecordBean medBean = new MedicalRecordBean();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "SELECT medical_record_id, patient_condition, medical_record_created_on, is_active, blood_transfusion_status "
				+ "FROM medical_records "
				+ "WHERE user_id=?";
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, userPatientId);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				medBean.setMedicalRecordId(rs.getString("medical_record_id"));
				medBean.setPatientCondition(rs.getString("patient_condition"));
				medBean.setMedicalRecordCreatedOn(rs.getObject("medical_record_created_on", LocalDateTime.class));
				medBean.setActive(rs.getBoolean("is_active"));
				medBean.setBloodTransfusionStatus("blood_transfusion_status");
			}
			System.out.println("Retrieving from medical record table...");
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closeConnection(con, preparedStatement, null);
		}
		return medBean;
	}
	
	public static String add(MedicalRecordBean medRecordBean) throws SQLException {
		
		String query = "INSERT INTO medical_records(medical_record_id, user_id, patient_condition, medical_record_created_on, is_active, "
				+ "blood_transfusion_status) values (?,?,?,?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				System.out.println("Adding medical record...");
				preparedStatement.setString(1, medRecordBean.getMedicalRecordId());
				preparedStatement.setString(2, medRecordBean.getUserId());
				preparedStatement.setString(3, medRecordBean.getPatientCondition());
				preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(medRecordBean.getMedicalRecordCreatedOn()));
				preparedStatement.setBoolean(5, medRecordBean.isActive());
				preparedStatement.setString(6, medRecordBean.getBloodTransfusionStatus());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add medical record to the database!";
		}
		return "Successfully added medical record to the database!";
	}
}
