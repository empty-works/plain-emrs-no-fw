package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordSocialHistoriesBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordSocialHistoriesDao {

	public static List<MedicalRecordSocialHistoriesBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordSocialHistoriesBean> socialHistories = new ArrayList<>();
		String query = "SELECT social_history_id, substances, occupation, sexual_behavior, "
				+ "prison, travel, exercise, diet, firearms_in_household "
				+ "FROM social_histories "
				+ "WHERE medical_record_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordSocialHistoriesBean socialHistory = new MedicalRecordSocialHistoriesBean();
					socialHistory.setSocialHistoryId(rs.getInt("social_history_id"));
					socialHistory.setSubstances(rs.getString("substances"));
					socialHistory.setOccupation(rs.getString("occupation"));
					socialHistory.setSexualBehavior(rs.getString("sexual_behavior"));
					socialHistory.setPrison(rs.getString("prison"));
					socialHistory.setTravel(rs.getString("travel"));
					socialHistory.setExercise(rs.getString("exercise"));
					socialHistory.setDiet(rs.getString("diet"));
					socialHistory.setFirearmsInHousehold(rs.getString("firearms_in_household"));
					socialHistories.add(socialHistory);
				}
			}
		}
		return socialHistories;
	}
	
	public static String add(MedicalRecordSocialHistoriesBean socialHistory) throws SQLException {
		
		String query = "INSERT INTO social_histories(medical_record_id, substances, occupation, "
				+ "sexual_behavior, prison, travel, exercise, diet, firearms_in_household) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, socialHistory.getMedicalRecordId());
				preparedStatement.setString(2, socialHistory.getSubstances());
				preparedStatement.setString(3, socialHistory.getOccupation());
				preparedStatement.setString(4, socialHistory.getSexualBehavior());
				preparedStatement.setString(5, socialHistory.getPrison());
				preparedStatement.setString(6, socialHistory.getTravel());
				preparedStatement.setString(7, socialHistory.getExercise());
				preparedStatement.setString(8, socialHistory.getDiet());
				preparedStatement.setString(9, socialHistory.getFirearmsInHousehold());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add to the social_histories table!";
		}
		return "Successfully added to the social_histories table!";
	}
}
