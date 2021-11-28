package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.FacilityStaffSpecialtyBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class FacilitySpecialtyDao {

	public static String SPECIALTYDAO_SUCCESS = "Success";
	
	public static String add(FacilityStaffSpecialtyBean fssb) {
		
		// Extract attributes
		String facilityId = fssb.getFacilityId();
		String specialtyId = fssb.getId();
		String specialtyName = fssb.getName();
		String specialtyDescription = fssb.getDescription();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "INSERT INTO staff_specialties(specialty_id, facility_id, name, description) values (?,?,?,?)";
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, specialtyId);
			preparedStatement.setString(2, facilityId);
			preparedStatement.setString(3, specialtyName);
			preparedStatement.setString(4, specialtyDescription);
			int i = preparedStatement.executeUpdate();
			if(i != 0) return SPECIALTYDAO_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Something went wrong writing staff specialty to the database.";
	}
}
