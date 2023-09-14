package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordChiefComplaintsBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

/**
 * 
 *
 */
public class MedicalRecordChiefComplaintsDao {

	/**
	 * 
	 * @param medicalRecordId
	 * @return
	 * @throws SQLException
	 */
	public static List<MedicalRecordChiefComplaintsBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordChiefComplaintsBean> medRecordChiefComplaintsBeanList = new ArrayList<>();
		String query = "SELECT chief_complaint_id, admissions_id, statement, chief_complaint_date "
				+ "FROM chief_complaints "
				+ "WHERE medical_record_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				
				System.out.println("Retrieving from the chief_complaints table...");
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordChiefComplaintsBean medRecordChiefComplaintsBean = new MedicalRecordChiefComplaintsBean();
					medRecordChiefComplaintsBean.setChiefComplaintId(rs.getString("chief_complaint_id"));
					medRecordChiefComplaintsBean.setAdmissionsId(rs.getInt("admissions_id"));
					medRecordChiefComplaintsBean.setStatement(rs.getString("statement"));
					medRecordChiefComplaintsBean.setDate(rs.getObject("chief_complaint_date", LocalDateTime.class));
					medRecordChiefComplaintsBeanList.add(medRecordChiefComplaintsBean);
				}
			}
		}
		return medRecordChiefComplaintsBeanList;
	}
	
	/**
	 * 
	 * @param medRecordChiefComplaintsBean
	 * @return
	 * @throws SQLException
	 */
	public static int add(MedicalRecordChiefComplaintsBean medRecordChiefComplaintsBean) throws SQLException {
		
		/*
		String query = "INSERT INTO chief_complaints(chief_complaint_id, medical_record_id, admissions_id, statement, chief_complaint_date) "
				+ "VALUES (?,?,?,?,?) "
				+ "SET @last_chief_complaint_id = LAST_INSERT_ID() "
				+ "INSERT INTO histories_present_illness(chief_complaint_id, medical_record_id, location, character, duration, onset, "
				+ "modifying_factors, radiation, temporal_pattern, severity, description) "
				+ "VALUES (@last_chief_complaint_id,?,?,?,?,?,?,?,?,?)";
		*/
		String query = "INSERT INTO chief_complaints(chief_complaint_id, medical_record_id, admissions_id, statement, chief_complaint_date) "
				+ "VALUES (?,?,?,?,?)";
		
		int success = 0;
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				System.out.println("Writing to the chief_complaints table...");
				preparedStatement.setString(1, medRecordChiefComplaintsBean.getChiefComplaintId());
				preparedStatement.setString(2, medRecordChiefComplaintsBean.getMedicalRecordId());
				preparedStatement.setInt(3, medRecordChiefComplaintsBean.getAdmissionsId());
				preparedStatement.setString(4, medRecordChiefComplaintsBean.getStatement());
				preparedStatement.setTimestamp(5, java.sql.Timestamp.valueOf(medRecordChiefComplaintsBean.getDate()));
				success = preparedStatement.executeUpdate();
			}
		}
		
		
		
		return success;
	}
	
	/**
	 * 
	 * @param newStatement
	 * @return
	 * @throws SQLException
	 */
	public static int updateStatement(String newStatement, String chiefComplaintId, String medRecordId) throws SQLException {
		
		System.out.println("Inside updateStatement() method in MedicalRecordChiefComplaintsDao...");
		String query = "UPDATE chief_complaints "
				+ "SET statement = ? "
				+ "WHERE chief_complaint_id = ? AND medical_record_id = ?";
		
		int success = 0;
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				System.out.println("Updating the statement in the chief_complaints table...");
				preparedStatement.setString(1, newStatement);
				preparedStatement.setString(2, chiefComplaintId);
				preparedStatement.setString(3, medRecordId);
				success = preparedStatement.executeUpdate();
			}
		}
		return success;
	}
}
