package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.MedicalRecordBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordDao {

	final public static String MEDICALRECORDDAO_SUCCESS = "Medical record successfully added!";
	
	public static String add(MedicalRecordBean medRecord) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "insert into medical_records(medical_record_id, user_id, patient_condition, medical_record_created_on, is_active, "
				+ "blood_transfusion_status) values (?,?,?,?,?,?)";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, medRecord.getMedicalRecordId());
			preparedStatement.setString(2, medRecord.getUserId());
			preparedStatement.setString(3, medRecord.getPatientCondition());
			preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(medRecord.getMedicalRecordCreatedOn()));
			preparedStatement.setBoolean(5, medRecord.isActive());
			preparedStatement.setString(6, medRecord.getBloodTransfusionStatus());
			
			int i = preparedStatement.executeUpdate();
			if(i != 0) return MEDICALRECORDDAO_SUCCESS;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatement, null);
		}
		
		return "Something went wrong. Could not add medical record.";
	}
}
