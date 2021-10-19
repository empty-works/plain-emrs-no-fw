package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.FacilityBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class FacilitySetupDao {
	
	final public static String FACILITYDAO_SUCCESS = "Success";

	public static String register(FacilityBean fb) {
		
		String id = fb.getId();
		String name = fb.getName();
		String streetAddress = fb.getStreetAddress();
		String city = fb.getCity();
		String state = fb.getState();
		String country = fb.getCountry();
		String zipCode = fb.getZipCode();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		con = ConnectionUtil.getConnection();
		String query = "insert into facilities("
				+ "facility_id, name, street_address, city, state, country, zip_code) "
				+ "values (?,?,?,?,?,?,?)";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, streetAddress);
			preparedStatement.setString(4, city);
			preparedStatement.setString(5, state);
			preparedStatement.setString(6, country);
			preparedStatement.setString(7, zipCode);

			int i = preparedStatement.executeUpdate();
			if(i != 0) return FACILITYDAO_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Something went wrong registering the facility into the database...";
	}
}
