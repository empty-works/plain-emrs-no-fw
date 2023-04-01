package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.UserAssignedPatientsBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class UserAssignedPatientsDao {

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public static List<UserAssignedPatientsBean> get(String userId) throws SQLException {
		
		List<UserAssignedPatientsBean> assignedPatients = new ArrayList<>();
		String query = "SELECT patient_user_id "
				+ "FROM assigned_patients "
				+ "WHERE staff_user_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, userId);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					UserAssignedPatientsBean assignedPatient = new UserAssignedPatientsBean();
					assignedPatient.setPatientUserId(userId);
					assignedPatients.add(assignedPatient);
				}
			}
		}
		return assignedPatients;
	}
	
	/**
	 * 
	 * @param assignedPatient
	 * @return
	 * @throws SQLException
	 */
	public static String add(UserAssignedPatientsBean assignedPatient) throws SQLException {
		
		String query = "INSERT INTO assigned_patients(staff_user_id, patient_user_id) "
				+ "VALUES (?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, assignedPatient.getUserId());
				preparedStatement.setString(2, assignedPatient.getPatientUserId());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add to the assigned_patients table!";
		}
		return "Successfully added to the assigned_patients table!";
	}
}
