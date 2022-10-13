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
		
		String query = "insert into blood_relatives(user_id, medical_record_id, blood_relation, alive_status, deceased_age, cause_of_death) "
				+ "values (?,?,?,?,?,?)";
		
		try {
			preparedStatement = con.prepareStatement(query);
			// Mother and father before siblings.
			preparedStatement.setString(1, relations.getUserId());
			preparedStatement.setString(2, relations.getMedicalRecordId());
			preparedStatement.setString(3, relations.);
			for(int i = 0; i < relations.getRelations().size(); i++) {
				
				preparedStatement.setString(1, relations.getUserId());
				preparedStatement.setString(2, relations.getMedicalRecordId());
				preparedStatement.setString(3, relations.getRelations().get(i).getRelation());
				//preparedStatement.setString(4, relations.getRelations().get(i).);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return RELATIONSDAO_SUCCESS;
	}
}
