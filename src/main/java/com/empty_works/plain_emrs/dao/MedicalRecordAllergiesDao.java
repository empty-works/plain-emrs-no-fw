package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordAllergiesBean;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordAllergyUnit;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordAllergiesDao {

	final public static String MEDICALRECORDALLERGIESDAO_SUCCESS = "Allergies medical record successfully added!";
	
	public static List<MedicalRecordAllergiesBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordAllergiesBean> medRecordAllergiesList = new ArrayList<>();
		String query = "SELECT allergies_id, allergy_name, allergy_severity, additional_information "
				+ "FROM allergies "
				+ "WHERE medical_record_id=?";

		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				ResultSet rs = preparedStatement.executeQuery();
				System.out.println("Retrieving from the allergies table...");
				while(rs.next()) {
					MedicalRecordAllergiesBean medRecordAllergies = new MedicalRecordAllergiesBean();
					medRecordAllergies.setAllergyId(rs.getInt("allergies_id"));
					medRecordAllergies.setAllergyName(rs.getString("allergy_name"));
					medRecordAllergiesList.add(medRecordAllergies);
				}
			}
		}
		return medRecordAllergiesList;
	}
	
	public static String add(List<MedicalRecordAllergiesBean> allergiesList) throws SQLException {
		
		String query = "INSERT INTO allergies(medical_record_id, allergy_name, allergy_severity, additional_information) VALUES (?,?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				if(allergiesList != null && allergiesList.size() > 0) {
					for(MedicalRecordAllergiesBean allergyUnit : allergiesList) {
						
						System.out.println("Adding to allergies table...");
						preparedStatement.setString(1, allergyUnit.getMedicalRecordId());
						preparedStatement.setString(2, allergyUnit.getAllergyName());
						preparedStatement.setString(3, allergyUnit.getAllergySeverity());
						preparedStatement.setString(4, allergyUnit.getAdditionalInformation());
						preparedStatement.addBatch();
					}
					success = preparedStatement.executeBatch()[0];
				}
			}
		}
		if(success == 0) {
			return "Could not add patient allergies to the database!";
			
		} 
		return "Successfully added patient allergies to the database!";
	}
}
