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

	public static List<MedicalRecordDiseasesBean> get(String medicalRecordId) {
		
		List<MedicalRecordDiseasesBean> medRecordDiseasesBeanList = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "SELECT disease_id, disease, contracted_disease, received_immunization "
				+ "FROM diseases "
				+ "WHERE medical_record_id=?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, medicalRecordId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				MedicalRecordDiseasesBean medRecordDiseasesBean = new MedicalRecordDiseasesBean();
				medRecordDiseasesBean.setDiseaseId(rs.getInt("disease_id"));
				medRecordDiseasesBean.setDisease(rs.getString("disease"));
				medRecordDiseasesBean.setContractedDisease(rs.getBoolean("contracted_disease"));
				medRecordDiseasesBean.setReceivedImmunization(rs.getBoolean("received_immunization"));
				medRecordDiseasesBeanList.add(medRecordDiseasesBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return medRecordDiseasesBeanList;
	}
	
	public static int add(MedicalRecordDiseasesBean medRecordDiseasesBean) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "INSERT INTO diseases(medical_record_id, disease, contracted_disease, received_immunization) "
				+ "values (?,?,?,?)";

		int success = 0;
		try {
			preparedStatement = con.prepareStatement(query);
			List<MedicalRecordDiseaseUnit> diseases = medRecordDiseasesBean.getDiseases();
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
}
