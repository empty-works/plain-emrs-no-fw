package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordDiseasesBean;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseUnit;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordDiseasesDao {

	public static List<MedicalRecordDiseasesBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordDiseasesBean> medRecordDiseasesBeanList = new ArrayList<>();
		String query = "SELECT immunization_id, disease_id, disease, immunization "
				+ "FROM immunizations "
				+ "WHERE medical_record_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				System.out.println("Retrieving from the immunizations table...");
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordDiseasesBean medRecordDiseasesBean = new MedicalRecordDiseasesBean();
					medRecordDiseasesBean.setImmunizationId(rs.getInt("immunization_id"));
					medRecordDiseasesBean.setDiseaseId(rs.getString("disease_id"));
					medRecordDiseasesBean.setDisease(rs.getString("disease"));
					medRecordDiseasesBean.setImmunization(rs.getString("immunization"));
					medRecordDiseasesBeanList.add(medRecordDiseasesBean);
				}
			}
		}
		return medRecordDiseasesBeanList;
	}
	
	public static String add(List<MedicalRecordDiseasesBean> immunizationsList) throws SQLException {
		
		String query = "INSERT INTO immunizations(medical_record_id, immunization, disease, disease_id) "
				+ "values (?,?,?,?)";

		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				if(immunizationsList != null && immunizationsList.size() > 0) {
					for(MedicalRecordDiseasesBean immunization : immunizationsList) {
						
						System.out.println("Adding to the immunizations table...");
						preparedStatement.setString(1, immunization.getMedicalRecordId());
						preparedStatement.setString(2, immunization.getImmunization());
						preparedStatement.setString(3, immunization.getDisease());
						preparedStatement.setString(4, immunization.getDiseaseId());
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
