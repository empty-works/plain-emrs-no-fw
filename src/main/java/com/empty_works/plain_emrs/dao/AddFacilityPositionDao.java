package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.FacilityStaffPositionBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class AddFacilityPositionDao {
	
	public static String ADDFACPOSITIONDAO_SUCCESS = "Success";

	public static String add(FacilityStaffPositionBean fspb) {
		
		String staffPositionId = fspb.getStaffPositionId();
		String facilityId = fspb.getFacilityId();
		String positionName = fspb.getName();
		String positionDescription = fspb.getDescription();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		con = ConnectionUtil.getConnection();
		String query = "insert into staff_positions(staff_position_id, facility_id, name, description) values (?,?,?,?)";
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, staffPositionId);
			preparedStatement.setString(2, facilityId);
			preparedStatement.setString(3, positionName);
			preparedStatement.setString(4, positionDescription);
			int i = preparedStatement.executeUpdate();
			if(i != 0) return ADDFACPOSITIONDAO_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Something went wrong with adding facility staff positions to the database!";
	}
}
