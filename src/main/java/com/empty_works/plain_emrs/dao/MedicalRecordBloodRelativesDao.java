package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.MedicalRecordBean;
import com.empty_works.plain_emrs.beans.MedicalRecordBloodRelativesBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordBloodRelativesDao {

	public static MedicalRecordBloodRelativesBean get(String medicalRecordId) throws SQLException {
		
		MedicalRecordBloodRelativesBean medRecordBloodRelativesBean = new MedicalRecordBloodRelativesBean();
		String query = "SELECT blood_relatives_id, mother_status, father_status, mother_deceased_age, father_deceased_age, num_sisters_alive, "
				+ "num_brothers_alive, num_daughters_alive, num_sons_alive, mother_cause_of_death, father_cause_of_death "
				+ "FROM blood_relatives "
				+ "WHERE medical_record_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				ResultSet rs = preparedStatement.executeQuery();
				System.out.println("Retrieving from the blood_relatives table...");
				while(rs.next()) {
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
				}
			}
		}
		return medRecordBloodRelativesBean;
	}
	
	public static String add(MedicalRecordBloodRelativesBean medRecordBloodRelativesBean) throws SQLException {
		
		String query = "INSERT INTO blood_relatives(medical_record_id, mother_status, father_status, mother_deceased_age, father_deceased_age,"
				+ "num_sisters_alive, num_brothers_alive, num_daughters_alive, num_sons_alive, mother_cause_of_death, father_cause_of_death) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				System.out.println("Mother status: " + medRecordBloodRelativesBean.getMotherStatus());
				System.out.println("Father status: " + medRecordBloodRelativesBean.getFatherStatus());
				System.out.println("Mother age: " + medRecordBloodRelativesBean.getMothDecAge());
				System.out.println("Father age: " + medRecordBloodRelativesBean.getFathDecAge());
				System.out.println("Num sisters: " + medRecordBloodRelativesBean.getNumSisters());
				System.out.println("Num brothers: " + medRecordBloodRelativesBean.getNumBrothers());
				System.out.println("Num daughters: " + medRecordBloodRelativesBean.getNumDaughters());
				System.out.println("Num sons: " + medRecordBloodRelativesBean.getNumSons());
				preparedStatement.setString(1, medRecordBloodRelativesBean.getMedicalRecordId());
				preparedStatement.setString(2, medRecordBloodRelativesBean.getMotherStatus());
				preparedStatement.setString(3, medRecordBloodRelativesBean.getFatherStatus());
				preparedStatement.setInt(4, medRecordBloodRelativesBean.getMothDecAge());
				preparedStatement.setInt(5, medRecordBloodRelativesBean.getFathDecAge());
				preparedStatement.setInt(6, medRecordBloodRelativesBean.getNumSisters());
				preparedStatement.setInt(7, medRecordBloodRelativesBean.getNumBrothers());
				preparedStatement.setInt(8, medRecordBloodRelativesBean.getNumDaughters());
				preparedStatement.setInt(9, medRecordBloodRelativesBean.getNumSons());
				preparedStatement.setString(10, medRecordBloodRelativesBean.getMothCauseDea());
				preparedStatement.setString(11, medRecordBloodRelativesBean.getFathCauseDea());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add patient blood relations to the database!";
		}
		return "Successfully added patient blood relations to the database!";
	}
}
