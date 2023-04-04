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
		String query = "SELECT disease_id, disease, contracted_disease, received_immunization "
				+ "FROM diseases "
				+ "WHERE medical_record_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				System.out.println("Retrieving from the diseases table...");
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordDiseasesBean medRecordDiseasesBean = new MedicalRecordDiseasesBean();
					medRecordDiseasesBean.setDiseaseId(rs.getInt("disease_id"));
					medRecordDiseasesBean.setDisease(rs.getString("disease"));
					medRecordDiseasesBean.setContractedDisease(rs.getBoolean("contracted_disease"));
					medRecordDiseasesBean.setReceivedImmunization(rs.getBoolean("received_immunization"));
					medRecordDiseasesBeanList.add(medRecordDiseasesBean);
				}
			}
		}
		return medRecordDiseasesBeanList;
	}
	
	public static String add(MedicalRecordDiseasesBean medRecordDiseasesBean) throws SQLException {
		
		String query = "INSERT INTO diseases(medical_record_id, disease, contracted_disease, received_immunization) "
				+ "values (?,?,?,?)";

		List<MedicalRecordDiseaseUnit> diseases = medRecordDiseasesBean.getDiseases();
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				if(diseases != null && diseases.size() > 0) {
					for(int i = 0; i < diseases.size(); i++) {
						
						preparedStatement.setString(1, medRecordDiseasesBean.getMedicalRecordId());
						preparedStatement.setString(2, diseases.get(i).getDiseaseName());
						preparedStatement.setBoolean(3, diseases.get(i).isContractedDisease());
						preparedStatement.setBoolean(4, diseases.get(i).isImmunized());
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
