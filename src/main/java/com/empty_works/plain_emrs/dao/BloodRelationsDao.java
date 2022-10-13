package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.BloodRelationsBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class BloodRelationsDao {

	final public static String RELATIONSDAO_SUCCESS = "Blood relations successfully added!";
	
	public static String add(BloodRelationsBean relations) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "insert into blood_relatives(user_id, medical_record_id, mother_status, father_status, mother_deceased_age, father_deceased_age,"
				+ "num_sisters_alive, num_brothers_alive, num_daughters_alive, num_sons_alive, mother_cause_of_death, father_cause_of_death) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, relations.getUserId());
			preparedStatement.setString(2, relations.getMedicalRecordId());
			preparedStatement.setString(3, relations.getMotherStatus());
			preparedStatement.setString(4, relations.getFatherStatus());
			preparedStatement.setInt(5, relations.getMothDecAge());
			preparedStatement.setInt(6, relations.getFathDecAge());
			preparedStatement.setInt(7, relations.getNumSisters());
			preparedStatement.setInt(8, relations.getNumBrothers());
			preparedStatement.setInt(9, relations.getNumDaughters());
			preparedStatement.setInt(10, relations.getNumSons());
			preparedStatement.setString(11, relations.getMothCauseDea());
			preparedStatement.setString(12, relations.getFathCauseDea());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return RELATIONSDAO_SUCCESS;
	}
}
