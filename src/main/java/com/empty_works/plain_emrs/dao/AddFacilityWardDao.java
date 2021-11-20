package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.FacilityWardBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class AddFacilityWardDao {
	
	public static String ADDFACWARDDAO_SUCCESS = "Success";

	public static String add(FacilityWardBean fwb) {
		
		String wardId = fwb.getWardId();
		String facilityId = fwb.getFacilityId();
		String wardName = fwb.getName();
		String wardLocation = fwb.getLocation();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "insert into wards(ward_id, facility_id, name, location) values (?,?,?,?)";
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, wardId);
			preparedStatement.setString(2, facilityId);
			preparedStatement.setString(3, wardName);
			preparedStatement.setString(4, wardLocation);
			
			int i = preparedStatement.executeUpdate();
			if(i != 0) return ADDFACWARDDAO_SUCCESS;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Something went wrong! Could not add facility ward.";
	}
}
