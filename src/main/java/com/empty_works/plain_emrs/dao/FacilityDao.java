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
import com.empty_works.plain_emrs.util.QueryUtil;

public class FacilityDao {
	
	final public static String FACILITYDAO_SUCCESS = "Success";
	
	/**
	 * 
	 * @param facilityId
	 * @return
	 */
	public static FacilityBean getFacility(String facilityId) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "select facility_name, facility_street_address, facility_city, facility_state, "
				+ "facility_country, facility_zip_code, "
				+ "facility_number_of_beds, facility_description from facilities where facility_id=?";
		
		FacilityBean facility = new FacilityBean();
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, facilityId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {InputStream stream = resultSet.getBinaryStream(1);}
			
			facility.setId(facilityId);
			facility.setName(resultSet.getString("facility_name"));
			facility.setStreetAddress(resultSet.getString("facility_street_address"));
			facility.setCity(resultSet.getString("facility_city"));
			facility.setState(resultSet.getString("facility_state"));
			facility.setCountry(resultSet.getString("facility_country"));
			facility.setZipCode(resultSet.getString("facility_zip_code"));
			facility.setNumberOfBeds(resultSet.getInt("facility_number_of_beds"));
			java.sql.Blob daBlob = resultSet.getBlob("facility_description"); // Convert blob to String
			facility.setDescription(new String(daBlob.getBytes(1L, (int) daBlob.length())));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatement, null);
		}
		
		return facility;
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<FacilityBean> getList() {
		
		List<FacilityBean> facilitiesList = new ArrayList<>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
	
		String query = "select facility_id, facility_name, facility_city, facility_country from "
				+ "facilities";
		
		try {
			preparedStatement = con.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				FacilityBean facility = new FacilityBean();
				facility.setId(resultSet.getString("facility_id"));
				facility.setName(resultSet.getString("facility_name"));
				facility.setCity(resultSet.getString("facility_city"));
				facility.setCountry(resultSet.getString("facility_country"));
				System.out.println("FacilityDao facility ID: " + facility.getId());
				facilitiesList.add(facility);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatement, resultSet);
		}
		
		return facilitiesList;
	}

	/**
	 * 
	 * @param fb
	 * @return
	 */
	public static String add(FacilityBean fb) {
		
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
		
		String query = QueryUtil.insert("facilities", "facility_id", "facility_name", "facility_street_address", "facility_city", 
				"facility_state", "facility_country", "facility_zip_code", "facility_number_of_beds", "facility_description");
		
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
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatement, null);
		}
		
		return "Something went wrong registering the facility into the database...";
	}
	
	/**
	 * 
	 * @param fb
	 * @return
	 */
	public static String update(FacilityBean fb) {
		
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
		
		String query = "update facilities set facility_name=?, facility_street_address=?, facility_city=?, facility_state=?, "
				+ "facility_country=?, facility_zip_code=?, facility_number_of_beds=?, facility_description=? where facility_id=?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, streetAddress);
			preparedStatement.setString(3, city);
			preparedStatement.setString(4, state);
			preparedStatement.setString(5, country);
			preparedStatement.setString(6, zipCode);
			preparedStatement.setInt(7, numberOfBeds);
			preparedStatement.setString(8, description);
			preparedStatement.setString(9, id);
			int i = preparedStatement.executeUpdate();
			if(i != 0) return FACILITYDAO_SUCCESS;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatement, null);
		}
		return "Something went wrong with updating the facility to the database!";
	}
}
