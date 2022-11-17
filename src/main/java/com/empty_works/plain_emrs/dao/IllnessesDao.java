package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.IllnessesBean;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordFamilyIllnessUnit;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class IllnessesDao {

	public static String ILLNESSESDAO_SUCCESS = "Illnesses data successfully added.";
	
	public static String add(IllnessesBean illness) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "insert into illnesses(medical_record_id, illness, self, father, mother, brothers, sisters, "
				+ "sons, daughters, grandparents) values (?,?,?,?,?,?,?,?,?,?)";
	 	
		try {
			preparedStatement = con.prepareStatement(query);
			for(int i = 0; i < illness.getIllness().size(); i++) {
				
				preparedStatement.setString(1, illness.getMedicalRecordId());
				preparedStatement.setString(2, illness.getIllness().get(i).getFamilyIllness());
				addRelations(illness.getIllness().get(i), preparedStatement);
				preparedStatement.addBatch();
			}
			int[] checks = preparedStatement.executeBatch();
			for(int check : checks) {
				// If even one returns zero, insertion failed.
				if(check == 0) {return "Something went wrong. Could not add illnesses data.";}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ILLNESSESDAO_SUCCESS;
	}
	
	/**
	 * 
	 * @param illness
	 * @param preparedStatement
	 */
	private static void addRelations(MedicalRecordFamilyIllnessUnit illness, PreparedStatement preparedStatement) {
		
		int prepStatementNum = 3; // Prepared statement starts at 4.
		for(int i = 0; i < illness.getFamilyRelations().size(); i++) {
			
			try {
				preparedStatement.setBoolean(prepStatementNum, illness.getFamilyRelations().get(i));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
