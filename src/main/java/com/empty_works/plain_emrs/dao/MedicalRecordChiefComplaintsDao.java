package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordChiefComplaintsBean;
import com.empty_works.plain_emrs.beans.MedicalRecordHistoriesPresentIllnessBean;
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
	public static int add(MedicalRecordChiefComplaintsBean medRecordChiefComplaintsBean, MedicalRecordHistoriesPresentIllnessBean hpiBean) throws SQLException {
		
		/*
		String query = "INSERT INTO chief_complaints(chief_complaint_id, medical_record_id, admissions_id, statement, chief_complaint_date) "
				+ "VALUES (?,?,?,?,?) "
				+ "SET @last_chief_complaint_id = LAST_INSERT_ID() "
				+ "INSERT INTO histories_present_illness(chief_complaint_id, medical_record_id, location, character, duration, onset, "
				+ "modifying_factors, radiation, temporal_pattern, severity, description) "
				+ "VALUES (@last_chief_complaint_id,?,?,?,?,?,?,?,?,?)";
		*/
		String chiefComplaintQuery = "INSERT INTO chief_complaints(medical_record_id, admissions_id, statement, chief_complaint_date) "
				+ "VALUES (?,?,?,?,?)";
		
		String hpiQuery = "INSERT INTO histories_present_illness(chief_complaint_id, medical_record_id, location, character, duration, onset, "
				+ "modifying_factors, radiation, temporal_pattern, severity, description) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		int success = 0;
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			ResultSet generatedCCKeys;
			int lastChiefComplaintId = -1;
			try(PreparedStatement chiefComplaintPreparedStatement = con.prepareStatement(chiefComplaintQuery)) {
				System.out.println("Writing to the chief_complaints table...");
				chiefComplaintPreparedStatement.setString(1, medRecordChiefComplaintsBean.getMedicalRecordId());
				chiefComplaintPreparedStatement.setInt(2, medRecordChiefComplaintsBean.getAdmissionsId());
				chiefComplaintPreparedStatement.setString(3, medRecordChiefComplaintsBean.getStatement());
				chiefComplaintPreparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(medRecordChiefComplaintsBean.getDate()));
				success = chiefComplaintPreparedStatement.executeUpdate();
				
				generatedCCKeys = chiefComplaintPreparedStatement.getGeneratedKeys();
				if(generatedCCKeys.next()) {
					lastChiefComplaintId = generatedCCKeys.getInt(1);
				}
			}
			
			try(PreparedStatement hpiPreparedStatement = con.prepareStatement(hpiQuery)) {
				System.out.println("Writing to the histories_present_illness...");
				hpiPreparedStatement.setInt(1, lastChiefComplaintId);
				hpiPreparedStatement.setString(2, hpiBean.getMedicalRecordId());
				hpiPreparedStatement.setString(3, hpiBean.getLocation());
				hpiPreparedStatement.setString(4, hpiBean.getCharacter());
				hpiPreparedStatement.setString(5, hpiBean.getDuration());
				hpiPreparedStatement.setString(6, hpiBean.getOnset());
				hpiPreparedStatement.setString(7, hpiBean.getModifyingFactors());
				hpiPreparedStatement.setString(8, hpiBean.getRadiation());
				hpiPreparedStatement.setString(9, hpiBean.getTemporalPattern());
				hpiPreparedStatement.setString(10, hpiBean.getSeverity());
				hpiPreparedStatement.setString(11, hpiBean.getDescription());
				success = hpiPreparedStatement.executeUpdate();
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
