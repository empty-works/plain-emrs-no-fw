package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordFamilyIllnessesBean;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordFamilyIllnessUnit;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordFamilyIllnessesDao {

	public static List<MedicalRecordFamilyIllnessesBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordFamilyIllnessesBean> medRecordFamilyIllnessesBeanList = new ArrayList<>();
		String query = "SELECT illness_id, illness, father, mother, brothers, sisters, sons, daughters, grandparents "
				+ "FROM family_illnesses "
				+ "WHERE medical_record_id=?";

		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				System.out.println("Retrieving from the family_illnesses table...");
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordFamilyIllnessesBean medRecordFamilyIllnessesBean = new MedicalRecordFamilyIllnessesBean();
					medRecordFamilyIllnessesBean.setIllnessId(rs.getInt("illness_id"));
					medRecordFamilyIllnessesBean.setIllness(rs.getString("illness"));
					medRecordFamilyIllnessesBean.setIllnessFather(rs.getBoolean("father"));
					medRecordFamilyIllnessesBean.setIllnessMother(rs.getBoolean("mother"));
					medRecordFamilyIllnessesBean.setIllnessBrothers(rs.getBoolean("brothers"));
					medRecordFamilyIllnessesBean.setIllnessSisters(rs.getBoolean("sisters"));
					medRecordFamilyIllnessesBean.setIllnessSons(rs.getBoolean("sons"));
					medRecordFamilyIllnessesBean.setIllnessDaughters(rs.getBoolean("daughters"));
					medRecordFamilyIllnessesBean.setIllnessGrandparents(rs.getBoolean("grandparents"));
					medRecordFamilyIllnessesBeanList.add(medRecordFamilyIllnessesBean);
				}
			}
		}
		return medRecordFamilyIllnessesBeanList;
	}
	
	public static String add(List<MedicalRecordFamilyIllnessesBean> medRecordIllnessesList, String medicalRecordId) {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "INSERT INTO family_illnesses(medical_record_id, illness, father, mother, brothers, sisters, sons, daughters, grandparents) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		
		int success = 0;
		
		try {
			preparedStatement = con.prepareStatement(query);
			if(medRecordIllnessesList != null && medRecordIllnessesList.size() > 0) {
				for(MedicalRecordFamilyIllnessesBean familyIllness : medRecordIllnessesList) {
					preparedStatement.setString(1, medicalRecordId);
					preparedStatement.setString(2, familyIllness.getIllness());
					preparedStatement.setBoolean(3, familyIllness.isIllnessFather());
					preparedStatement.setBoolean(4, familyIllness.isIllnessMother());
					preparedStatement.setBoolean(5, familyIllness.isIllnessBrothers());
					preparedStatement.setBoolean(6, familyIllness.isIllnessSisters());
					preparedStatement.setBoolean(7, familyIllness.isIllnessSons());
					preparedStatement.setBoolean(8, familyIllness.isIllnessDaughters());
					preparedStatement.setBoolean(9, familyIllness.isIllnessGrandparents());
					preparedStatement.addBatch();
				}
				success = preparedStatement.executeBatch()[0];
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(success == 0) {
			return "Could not add family illnesses to the database!";
		}
		return "Successfully added family illnesses to the database!";
	}
}