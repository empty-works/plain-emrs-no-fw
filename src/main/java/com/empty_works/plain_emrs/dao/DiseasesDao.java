package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.MedicalRecordDiseasesBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class DiseasesDao {

	final public static String DISEASESDAO_SUCCESS = "Diseases data successfully added.";
	
	public static String add(MedicalRecordDiseasesBean diseases) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "insert into diseases(medical_record_id, disease, contracted_disease, received_immunization) "
				+ "values (?,?,?,?)";
		
		try {
			preparedStatement = con.prepareStatement(query);
			for(int i = 0; i < diseases.getDiseases().size(); i++) {
				
				preparedStatement.setString(1, diseases.getMedicalRecordId());
				preparedStatement.setString(2, diseases.getDiseases().get(i).getDiseaseName());
				preparedStatement.setBoolean(3, diseases.getDiseases().get(i).isContractedDisease());
				preparedStatement.setBoolean(4, diseases.getDiseases().get(i).isImmunized());
				preparedStatement.addBatch();
			}
			int[] checks = preparedStatement.executeBatch();
			for(int check : checks) {
				// If even one returns zero, insertion failed.
				if(check == 0) {return "Something went wrong. Could not add diseases data.";}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DISEASESDAO_SUCCESS;
	}
}
