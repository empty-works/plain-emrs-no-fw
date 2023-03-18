package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.MedicalRecordBean;
import com.empty_works.plain_emrs.beans.MedicalRecordBloodRelativesBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordBloodRelativesDao {

	public static MedicalRecordBloodRelativesBean get(String medicalRecordId) {
		
		MedicalRecordBloodRelativesBean medRecordBloodRelativesBean = new MedicalRecordBloodRelativesBean();

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "SELECT blood_relatives_id, mother_status, father_status, mother_deceased_age, father_deceased_age, num_sisters_alive, "
				+ "num_brothers_alive, num_daughters_alive, num_sons_alive, mother_cause_of_death, father_cause_of_death "
				+ "FROM blood_relatives "
				+ "WHERE medical_record_id=?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, medicalRecordId);
			
			ResultSet rs = preparedStatement.executeQuery();
			medRecordBloodRelativesBean.setBloodRelativesId(rs.getInt("blood_relatives_id"));
			medRecordBloodRelativesBean.setMotherStatus(rs.getString("mother_status"));
			medRecordBloodRelativesBean.setFatherStatus(rs.getString("father_status"));
			medRecordBloodRelativesBean.setMothDecAge(rs.getInt("mother_deceased_age"));
			medRecordBloodRelativesBean.setFathDecAge(rs.getInt("father_deceased_age")); 
			medRecordBloodRelativesBean.setNumSisters(rs.getInt("num_sisters_alive")); 
			medRecordBloodRelativesBean.setNumBrothers(rs.getInt("num_brothers_alive")); 
			medRecordBloodRelativesBean.setNumDaughters(rs.getInt("num_daughters_alive")); 
			medRecordBloodRelativesBean.setNumSons(rs.getInt("num_sons_alive")); 
			medRecordBloodRelativesBean.setMothCauseDea(rs.getString("mother_cause_of_death")); 
			medRecordBloodRelativesBean.setFathCauseDea(rs.getString("father_cause_of_death")); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return medRecordBloodRelativesBean;
	}
	
	public static String add(MedicalRecordBloodRelativesBean medRecordBloodRelativesBean) {
		
		return MedicalRecordDao.add(medRecordBloodRelativesBean);
	}
}
