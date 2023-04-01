package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.UserAuthorizedFacilitiesBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class UserAuthorizedFacilitiesDao {

	public static List<UserAuthorizedFacilitiesBean> get(String userId) throws SQLException {
		
		List<UserAuthorizedFacilitiesBean> facilities = new ArrayList<>();
		String query = "SELECT user_authorized_facilities_id, facility_id "
				+ "FROM user_authorized_facilities "
				+ "WHERE user_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, userId);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					UserAuthorizedFacilitiesBean facility = new UserAuthorizedFacilitiesBean();
					facility.setUserAuthorizedFacilitiesId(rs.getInt("user_authorized_facilities_id"));
					facility.setFacilityId(rs.getString("facility_id"));
					facilities.add(facility);
				}
			}
		}
		return facilities;
	}
	
	public static String add(UserAuthorizedFacilitiesBean facility) throws SQLException {
		
		String query = "INSERT INTO user_authorized_facilities(user_id, facility_id) "
				+ "VALUES (?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, facility.getUserId());
				preparedStatement.setString(2, facility.getFacilityId());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add to the user_authorized_facilities table!";
		}
		return "Successfully added to the user_authorized_facilities table!";
	}
}
