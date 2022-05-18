package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.empty_works.plain_emrs.beans.PatientBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;
import com.empty_works.plain_emrs.util.QueryUtil;

public class PatientDao {

	final public static String PATIENTDAO_SUCCESS = "Success";

	public static String getPatient(String patientId) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = QueryUtil.getWithCondition("patients", "patient_id", "patient_id", "patient_given_name", "patient_middle_initial", 
				"patient_last_name", "patient_date_of_birth", "patient_provider", "patient_provider_id", "patient_room", "patient_gender", 
				"patient_type", "patient_race", "patient_ethnicity", "patient_language_preference", "patient_street_address", "patient_city", 
				"patient_state", "patient_country", "patient_phone_number", "patient_facility_id");
		
		System.out.println("Patient get query: " + query);
		
		PatientBean pb = new PatientBean();
		try {

			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, patientId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param pb
	 * @return
	 */
	public static String add(PatientBean pb) {
		
		String id = pb.getId();
		String givenName = pb.getGivenName();
		String middleInitial = pb.getMiddleInitial();
		String lastName = pb.getLastName();
		LocalDate dateOfBirth = pb.getDateOfBirth(); 
		String gender = pb.getGender();
		String type = pb.getType();
		String race = pb.getRace();
		String ethnicity = pb.getEthnicity();
		String streetAddress = pb.getStreetAddress();
		String city = pb.getCity();
		String state = pb.getState();
		String country = pb.getCountry();
		String phoneNumber = pb.getPhoneNumber();
		String provider = pb.getProvider();
		String providerId = pb.getProviderId();
		String roomNumber = pb.getRoomNumber();
		String languagePreference = pb.getLanguagePreference();
		String facilityId = pb.getFacilityId();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = QueryUtil.add("patients", "patient_id", "patient_given_name", "patient_middle_initial", "patient_last_name", 
				"patient_date_of_birth", "patient_provider", "patient_provider_id", "patient_room", "patient_gender", "patient_type", 
				"patient_race", "patient_ethnicity", "patient_language_preference", "patient_street_address", "patient_city", "patient_state", 
				"patient_country", "patient_phone_number", "patient_facility_id");
		
		try {

			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, givenName);
			preparedStatement.setString(3, middleInitial);
			preparedStatement.setString(4, lastName);
			preparedStatement.setDate(5, java.sql.Date.valueOf(dateOfBirth));
			preparedStatement.setString(6, provider);
			preparedStatement.setString(7, providerId);
			preparedStatement.setString(8, roomNumber);
			preparedStatement.setString(9, gender);
			preparedStatement.setString(10, type);
			preparedStatement.setString(11, race);
			preparedStatement.setString(12, ethnicity);
			preparedStatement.setString(13, languagePreference);
			preparedStatement.setString(14, streetAddress);
			preparedStatement.setString(15, city);
			preparedStatement.setString(16, state);
			preparedStatement.setString(17, country);
			preparedStatement.setString(18, phoneNumber);
			preparedStatement.setString(19, facilityId);
			
			int i = preparedStatement.executeUpdate();
			if(i != 0) return PATIENTDAO_SUCCESS;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatement, null);
		}
		
		return "Something went wrong registering the patient into the database...";
	}
}
