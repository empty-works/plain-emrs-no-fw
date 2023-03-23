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

	public static List<MedicalRecordIllnessesBean> get(String medicalRecordId) {
		
		List<MedicalRecordIllnessesBean> medRecordIllnessesBeanList = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "SELECT illness_id, illness, self, father, mother, brothers, sisters, sons, daughters, grandparents "
				+ "FROM illnesses "
				+ "WHERE medical_record_id=?";

		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, medicalRecordId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				MedicalRecordIllnessesBean medRecordIllnessesBean = new MedicalRecordIllnessesBean();
				medRecordIllnessesBean.setIllnessId(rs.getInt("illness_id"));
				medRecordIllnessesBean.setIllness(rs.getString("illness"));
				medRecordIllnessesBean.setIllnessSelf(rs.getBoolean("self"));
				medRecordIllnessesBean.setIllnessFather(rs.getBoolean("father"));
				medRecordIllnessesBean.setIllnessMother(rs.getBoolean("mother"));
				medRecordIllnessesBean.setIllnessBrothers(rs.getBoolean("brothers"));
				medRecordIllnessesBean.setIllnessSisters(rs.getBoolean("sisters"));
				medRecordIllnessesBean.setIllnessSons(rs.getBoolean("sons"));
				medRecordIllnessesBean.setIllnessDaughters(rs.getBoolean("daughters"));
				medRecordIllnessesBean.setIllnessGrandparents(rs.getBoolean("grandparents"));
				medRecordIllnessesBeanList.add(medRecordIllnessesBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return medRecordIllnessesBeanList;
	}
	
	public static int add(MedicalRecordIllnessesBean medRecordIllnessesBean) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "INSERT INTO illnesses(medical_record_id, illness, self, father, mother, brothers, sisters, sons, daughters, grandparents) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
		
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

		return success;
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