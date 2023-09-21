package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordHistoriesPresentIllnessBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordHistoriesPresentIllnessDao {

	public static List<MedicalRecordHistoriesPresentIllnessBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordHistoriesPresentIllnessBean> hpiBeans = new ArrayList<>();
		String query = "SELECT history_present_illness_id, chief_complaint_id, location, character, "
				+ "duration, onset, modifying_factors, radiation, temporal_pattern, severity "
				+ "FROM histories_present_illness "
				+ "WHERE medical_record_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					
					MedicalRecordHistoriesPresentIllnessBean hpiBean = new MedicalRecordHistoriesPresentIllnessBean();
					hpiBean.setHistoryPresentIllnessId(rs.getInt("history_present_illness_id"));
					hpiBean.setChiefComplaintId(rs.getString("chief_complaint_id"));
					hpiBean.setLocation(rs.getString("location"));
					hpiBean.setCharacter(rs.getString("character"));
					hpiBean.setDuration(rs.getString("duration"));
					hpiBean.setOnset(rs.getString("onset"));
					hpiBean.setModifyingFactors(rs.getString("modifying_factors"));
					hpiBean.setRadiation(rs.getString("radiation"));
					hpiBean.setTemporalPattern(rs.getString("temporal_pattern"));
					hpiBean.setSeverity(rs.getString("severity"));
					hpiBeans.add(hpiBean);
				}
			}
		}
		return hpiBeans;
	}
	
	public static String add(MedicalRecordHistoriesPresentIllnessBean hpiBean) throws SQLException {
		
		String query = "INSERT INTO histories_present_illness(chief_complaint_id, medical_record_id, location, "
				+ "character, duration, onset, modifying_factors, radiation, temporal_pattern, severity) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, hpiBean.getChiefComplaintId());
				preparedStatement.setString(2, hpiBean.getMedicalRecordId());
				preparedStatement.setString(3, hpiBean.getLocation());
				preparedStatement.setString(4, hpiBean.getCharacter());
				preparedStatement.setString(5, hpiBean.getDuration());
				preparedStatement.setString(6, hpiBean.getOnset());
				preparedStatement.setString(7, hpiBean.getModifyingFactors());
				preparedStatement.setString(8, hpiBean.getRadiation());
				preparedStatement.setString(9, hpiBean.getTemporalPattern());
				preparedStatement.setString(10, hpiBean.getSeverity());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add to the histories_present_illness table!";
		}
		return "Successfully added to the histories_present_illness table!";
	}
}
