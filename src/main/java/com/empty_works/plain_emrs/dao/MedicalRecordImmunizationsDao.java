package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordImmunizationsBean;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseUnit;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordImmunizationsDao {

	public static List<MedicalRecordImmunizationsBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordImmunizationsBean> medRecordImmunizationsBeanList = new ArrayList<>();
		String query = "SELECT immunization_id, immunization "
				+ "FROM immunizations "
				+ "WHERE medical_record_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				System.out.println("Retrieving from the immunizations table...");
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordImmunizationsBean medRecordImmunizationsBean = new MedicalRecordImmunizationsBean();
					medRecordImmunizationsBean.setImmunizationId(rs.getInt("immunization_id"));
					medRecordImmunizationsBean.setImmunization(rs.getString("immunization"));
					medRecordImmunizationsBeanList.add(medRecordImmunizationsBean);
				}
			}
		}
		return medRecordImmunizationsBeanList;
	}
	
	public static String add(List<MedicalRecordImmunizationsBean> immunizationsList) throws SQLException {
		
		String query = "INSERT INTO immunizations(medical_record_id, immunization) "
				+ "values (?,?)";

		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				if(immunizationsList != null && immunizationsList.size() > 0) {
					for(MedicalRecordImmunizationsBean immunization : immunizationsList) {
						
						System.out.println("Adding to the immunizations table...");
						preparedStatement.setString(1, immunization.getMedicalRecordId());
						preparedStatement.setString(2, immunization.getImmunization());
						preparedStatement.addBatch();
					}
					success = preparedStatement.executeBatch()[0];
				}
			}
		}
		if(success == 0) {
			return "Could not add patient diseases to the database!";
		}
		return "Successfully added patient diseases to the database!";
	}
}
