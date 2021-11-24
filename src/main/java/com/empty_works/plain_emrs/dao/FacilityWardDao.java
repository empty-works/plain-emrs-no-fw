package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.FacilityWardBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class FacilityWardDao {

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

	public static List<FacilityWardBean> getList(String facilityId) {
		
		List<FacilityWardBean> list = new ArrayList<>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("select ward_id, name, location from wards where facility_id=?");
			ps.setString(1, facilityId);
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				
				FacilityWardBean fwb = new FacilityWardBean();
				fwb.setWardId(resultSet.getString("ward_id"));
				fwb.setName(resultSet.getString("name"));
				fwb.setLocation(resultSet.getString("location"));
				list.add(fwb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
