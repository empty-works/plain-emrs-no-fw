package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordPlansBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordPlansDao {

	public static List<MedicalRecordPlansBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordPlansBean> plans = new ArrayList<>();
		
		String query = "SELECT plan_id, chief_complaint_id, summation "
				+ "FROM plans "
				+ "WHERE medical_record_id=?";
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordPlansBean plan = new MedicalRecordPlansBean();
					plan.setPlanId(rs.getInt("plan_id"));
					plan.setChiefComplaintId(rs.getInt("chief_complaint_id"));
					plan.setSummation(rs.getString("summation"));
					plans.add(plan);
				}
			}
		}
		return plans;
	}
	
	public static String add(MedicalRecordPlansBean plan) throws SQLException {
		
		String query = "INSERT INTO plans(chief_complaint_id, medical_record_id, summation) "
				+ "VALUES (?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setInt(1, plan.getChiefComplaintId());
				preparedStatement.setString(2, plan.getMedicalRecordId());
				preparedStatement.setString(3, plan.getSummation());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add to the plans table!";
		}
		return "Successfully added to the plans table!";
	}
}
