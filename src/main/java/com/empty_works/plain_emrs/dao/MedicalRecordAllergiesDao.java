package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordAllergiesBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordAllergiesDao {

	final public static String MEDICALRECORDALLERGIESDAO_SUCCESS = "Allergies medical record successfully added!";
	
	public static List<MedicalRecordAllergiesBean> get(String medicalRecordId) {
		
		List<MedicalRecordAllergiesBean> medRecordAllergiesList = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "SELECT allergies_id, allergy_name "
				+ "FROM allergies "
				+ "WHERE medical_record_id=?";

		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, medicalRecordId);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				MedicalRecordAllergiesBean medRecordAllergies = new MedicalRecordAllergiesBean();
				medRecordAllergies.setAllergiesId(rs.getInt("allergies_id"));
				medRecordAllergies.setAllergyName(rs.getString("allergy_name"));
				medRecordAllergiesList.add(medRecordAllergies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return medRecordAllergiesList;
	}
	
	public static String add(MedicalRecordAllergiesBean medRecordAllergiesBean) throws SQLException {
		
		String query = "INSERT INTO allergies(allergies_id, medical_record_id, allergy_name) VALUES (?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				System.out.println("Adding to allergies table...");
				preparedStatement.setInt(1, medRecordAllergiesBean.getAllergiesId());
				preparedStatement.setString(2, medRecordAllergiesBean.getMedicalRecordId());
				preparedStatement.setString(3, medRecordAllergiesBean.getAllergyName());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add patient allergies to the database!";
		}
		return "Successfully added patient allergies to the database!";
	}
}
