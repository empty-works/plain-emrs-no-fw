package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.MedicalRecordBloodRelationsBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class BloodRelationsDao {

	final public static String RELATIONSDAO_SUCCESS = "Blood relations successfully added!";
	
	public static String add(MedicalRecordBloodRelationsBean relations) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "insert into blood_relatives(medical_record_id, mother_status, father_status, mother_deceased_age, father_deceased_age,"
				+ "num_sisters_alive, num_brothers_alive, num_daughters_alive, num_sons_alive, mother_cause_of_death, father_cause_of_death) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, relations.getMedicalRecordId());
			preparedStatement.setString(2, relations.getMotherStatus());
			preparedStatement.setString(3, relations.getFatherStatus());
			preparedStatement.setInt(4, relations.getMothDecAge());
			preparedStatement.setInt(5, relations.getFathDecAge());
			preparedStatement.setInt(6, relations.getNumSisters());
			preparedStatement.setInt(7, relations.getNumBrothers());
			preparedStatement.setInt(8, relations.getNumDaughters());
			preparedStatement.setInt(9, relations.getNumSons());
			preparedStatement.setString(10, relations.getMothCauseDea());
			preparedStatement.setString(11, relations.getFathCauseDea());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return RELATIONSDAO_SUCCESS;
	}
}
