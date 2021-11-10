package com.empty_works.plain_emrs.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.FacilityBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class FacilityDao {
	
	final public static String FACILITYDAO_SUCCESS = "Success";
	
	public static FacilityBean getFacility(String facilityId) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "select name, street_address, city, state, country, zip_code, "
				+ "number_of_beds, description from facilities where facility_id=?";
		
		FacilityBean facility = new FacilityBean();
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, facilityId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {InputStream stream = resultSet.getBinaryStream(1);}
			
			facility.setId(facilityId);
			facility.setName(resultSet.getString("name"));
			facility.setStreetAddress(resultSet.getString("street_address"));
			facility.setCity(resultSet.getString("city"));
			facility.setState(resultSet.getString("state"));
			facility.setCountry(resultSet.getString("country"));
			facility.setZipCode(resultSet.getString("zip_code"));
			facility.setNumberOfBeds(resultSet.getInt("number_of_beds"));
			java.sql.Blob daBlob = resultSet.getBlob("description"); // Convert blob to String
			facility.setDescription(new String(daBlob.getBytes(1L, (int) daBlob.length())));
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return facility;
	}
	
	public static List<FacilityBean> getList() {
		
		List<FacilityBean> facilitiesList = new ArrayList<>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
	
		String query = "select facility_id, name, city, country from facilities";
		
		try {
			preparedStatement = con.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				FacilityBean facility = new FacilityBean();
				facility.setId(resultSet.getString("facility_id"));
				facility.setName(resultSet.getString("name"));
				facility.setCity(resultSet.getString("city"));
				facility.setCountry(resultSet.getString("country"));
				System.out.println("FacilityDao facility ID: " + facility.getId());
				facilitiesList.add(facility);
			}
			
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return facilitiesList;
	}

	public static String register(FacilityBean fb) {
		
		String id = fb.getId();
		String name = fb.getName();
		String streetAddress = fb.getStreetAddress();
		String city = fb.getCity();
		String state = fb.getState();
		String country = fb.getCountry();
		String zipCode = fb.getZipCode();
		int numberOfBeds = fb.getNumberOfBeds();
		String description = fb.getDescription();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "insert into facilities("
				+ "facility_id, name, street_address, city, state, country, zip_code, number_of_beds, description) "
				+ "values (?,?,?,?,?,?,?,?,?)";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, streetAddress);
			preparedStatement.setString(4, city);
			preparedStatement.setString(5, state);
			preparedStatement.setString(6, country);
			preparedStatement.setString(7, zipCode);
			preparedStatement.setInt(8, numberOfBeds);
			preparedStatement.setString(9, description);

			int i = preparedStatement.executeUpdate();
			if(i != 0) return FACILITYDAO_SUCCESS;
			
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Something went wrong registering the facility into the database...";
	}
}
