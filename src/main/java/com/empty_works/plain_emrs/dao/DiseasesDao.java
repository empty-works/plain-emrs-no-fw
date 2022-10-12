package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.DiseasesBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class DiseasesDao {

	final public static String DISEASESDAO_SUCCESS = "Diseases data successfully added.";
	
	public static String add(DiseasesBean diseases, String facilityId) {
		
		String userId = diseases.getUserId(); 
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "insert into diseases(user_id, medical_record_id, disease, contracted_disease, received_immunization) "
				+ "values (?,?,?,?,?)";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, diseases.getUserId());
			preparedStatement.setString(2, diseases.getMedicalRecordId());
			preparedStatement.setString(3, diseases.set);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
