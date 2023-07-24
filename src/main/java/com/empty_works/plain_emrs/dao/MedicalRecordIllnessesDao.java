package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordIllnessesBean;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordFamilyIllnessUnit;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordIllnessesDao {

	public static List<MedicalRecordIllnessesBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordIllnessesBean> medRecordIllnessesBeanList = new ArrayList<>();
		String query = "SELECT illness_id, illness, father, mother, brothers, sisters, sons, daughters, grandparents "
				+ "FROM family_illnesses "
				+ "WHERE medical_record_id=?";

		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				System.out.println("Retrieving from the family_illnesses table...");
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordIllnessesBean medRecordIllnessesBean = new MedicalRecordIllnessesBean();
					medRecordIllnessesBean.setIllnessId(rs.getInt("illness_id"));
					medRecordIllnessesBean.setIllness(rs.getString("illness"));
					medRecordIllnessesBean.setIllnessFather(rs.getBoolean("father"));
					medRecordIllnessesBean.setIllnessMother(rs.getBoolean("mother"));
					medRecordIllnessesBean.setIllnessBrothers(rs.getBoolean("brothers"));
					medRecordIllnessesBean.setIllnessSisters(rs.getBoolean("sisters"));
					medRecordIllnessesBean.setIllnessSons(rs.getBoolean("sons"));
					medRecordIllnessesBean.setIllnessDaughters(rs.getBoolean("daughters"));
					medRecordIllnessesBean.setIllnessGrandparents(rs.getBoolean("grandparents"));
					medRecordIllnessesBeanList.add(medRecordIllnessesBean);
				}
			}
		}
		return medRecordIllnessesBeanList;
	}
	
	public static String add(MedicalRecordIllnessesBean medRecordIllnessesBean) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "INSERT INTO family_illnesses(medical_record_id, illness, father, mother, brothers, sisters, sons, daughters, grandparents) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		
		int success = 0;

		try {
			preparedStatement = con.prepareStatement(query);
			List<MedicalRecordFamilyIllnessUnit> illnesses = medRecordIllnessesBean.getIllnesses();
			if(illnesses != null && illnesses.size() > 0) {
				for(int i = 0; i < illnesses.size(); i++) {
					preparedStatement.setString(1, medRecordIllnessesBean.getMedicalRecordId());
					preparedStatement.setString(2, illnesses.get(i).getFamilyIllness());
					addRelations(illnesses.get(i), preparedStatement);
					preparedStatement.addBatch();
				}
				success = preparedStatement.executeBatch()[0];
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(success == 0) {
			return "Could not add patient illnesses to the database!";
		}
		return "Successfully added patient illnesses to the database!";
	}

	/**
	 * 
	 * @param illness
	 * @param preparedStatement
	 */
	private static void addRelations(MedicalRecordFamilyIllnessUnit illness, PreparedStatement preparedStatement) {
		
		int prepStatementNum = 3; // Prepared statement starts at 3.
		for(int i = 0; i < illness.getFamilyRelations().size(); i++) {
			try {
				preparedStatement.setBoolean(prepStatementNum, illness.getFamilyRelations().get(i));
				prepStatementNum++;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}