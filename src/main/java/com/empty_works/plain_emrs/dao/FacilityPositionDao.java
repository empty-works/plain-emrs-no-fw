package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.FacilityStaffPositionBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class FacilityPositionDao {
	
	public static String ADDFACPOSITIONDAO_SUCCESS = "Success";

	public static String add(FacilityStaffPositionBean fspb) {
		
		String staffPositionId = fspb.getStaffPositionId();
		String facilityId = fspb.getFacilityId();
		String positionName = fspb.getName();
		String positionDescription = fspb.getDescription();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		con = ConnectionUtil.getConnection();
		String query = "insert into staff_positions(staff_position_id, facility_id, staff_position_name, "
				+ "staff_position_description) values (?,?,?,?)";
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
		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatement, null);
		}
		
		return "Something went wrong with adding facility staff positions to the database!";
	}
	
	public static List<FacilityStaffPositionBean> getList(String facilityId) {
		
		// Declare list
		List<FacilityStaffPositionBean> fspbList = new ArrayList<>();
		
		// Make connection and prepared statement
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		// Make and execute query
		try {
			preparedStatement = con.prepareStatement("select staff_position_id, staff_position_name, "
					+ "staff_position_description from staff_positions WHERE facility_id=?");
			preparedStatement.setString(1, facilityId);
			resultSet = preparedStatement.executeQuery();

			// Loop through result set and create new facility positions beans and add to list
			while(resultSet.next()) {
				
				FacilityStaffPositionBean fspb = new FacilityStaffPositionBean();
				fspb.setFacilityId(facilityId);
				fspb.setStaffPositionId(resultSet.getString("staff_position_id"));
				fspb.setName(resultSet.getString("staff_position_name"));
				java.sql.Blob spd = resultSet.getBlob("staff_position_description");
				fspb.setDescription(new String(spd.getBytes(1L, (int) spd.length())));
				fspbList.add(fspb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatement, resultSet);
		}
		
		return fspbList;
	}
}
