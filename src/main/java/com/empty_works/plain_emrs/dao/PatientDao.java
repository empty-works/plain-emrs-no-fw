package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;

import com.empty_works.plain_emrs.beans.PatientBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;
import com.empty_works.plain_emrs.util.QueryUtil;

public class PatientDao {

	final public static String PATIENTDAO_SUCCESS = "Success!";

	public static PatientBean getPatient(String patientId) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "SELECT patient_given_name, patient_middle_initial, patient_last_name, patient_date_of_birth, "
				+ "patient_provider, patient_provider_id, patient_room, patient_gender, patient_type, "
				+ "patient_race, patient_ethnicity, patient_language_preference, patient_street_address, "
				+ "patient_city, patient_state, patient_country, patient_phone_number, patient_facility_id"
				+ " FROM patients WHERE patient_id=?";
		
		System.out.println("Patient get query: " + query);
		
		PatientBean patient = new PatientBean();
		try {

			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, patientId);
			ResultSet resultSet = preparedStatement.executeQuery();
			// Check if the result set is empty.
			if(resultSet.next()) {InputStream stream = resultSet.getBinaryStream(1);}
			
			patient.setPatientId(patientId);
			patient.setGivenName(resultSet.getString("patient_given_name"));
			patient.setMiddleInitial(resultSet.getString("patient_middle_initial"));
			patient.setLastName(resultSet.getString("patient_last_name"));
			patient.setDateOfBirth(resultSet.getObject("patient_date_of_birth", LocalDate.class));
			patient.setProvider(resultSet.getString("patient_provider"));
			patient.setProviderId(resultSet.getString("patient_provider_id"));
			patient.setRoomNumber(resultSet.getString("patient_room"));
			patient.setGender(resultSet.getString("patient_gender"));
			patient.setType(resultSet.getString("patient_type"));
			patient.setRace(resultSet.getString("patient_race"));
			patient.setEthnicity(resultSet.getString("patient_ethnicity"));
			patient.setLanguagePreference(resultSet.getString("patient_language_preference"));
			patient.setStreetAddress(resultSet.getString("patient_street_address"));
			patient.setCity(resultSet.getString("patient_city"));
			patient.setState(resultSet.getString("patient_state"));
			patient.setCountry(resultSet.getString("patient_country"));
			patient.setPhoneNumber(resultSet.getString("patient_phone_number"));
			patient.setFacilityId(resultSet.getString("patient_facility_id"));
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatement, null);
		}
		
		return patient;
	}
	
	public static List<PatientBean> getList() {
		
		List<PatientBean> patientsList = new ArrayList<>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String query = "SELECT patient_id, patient_given_name, patient_middle_initial, patient_last_name, "
				+ "patient_date_of_birth, patient_gender, patient_type, patient_race, patient_ethnicity, "
				+ "patient_language_preference, patient_facility_id FROM patients";

		try {

			preparedStatement = con.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				PatientBean patient = new PatientBean();
				patient.setPatientId(resultSet.getString("patient_id"));
				patient.setGivenName(resultSet.getString("patient_given_name"));
				patient.setMiddleInitial(resultSet.getString("patient_middle_initial"));
				patient.setLastName(resultSet.getString("patient_last_name"));
				patient.setDateOfBirth(resultSet.getObject("patient_date_of_birth", LocalDate.class));
				patient.setGender(resultSet.getString("patient_gender"));
				patient.setType(resultSet.getString("patient_type"));
				patient.setRace(resultSet.getString("patient_race"));
				patient.setEthnicity(resultSet.getString("patient_ethnicity"));
				patient.setLanguagePreference(resultSet.getString("patient_language_preference"));
				patient.setFacilityId(resultSet.getString("patient_facility_id"));
				patientsList.add(patient);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatement, resultSet);
		}
		
		return patientsList;
	}
	
	/**
	 * 
	 * @param pb
	 * @return
	 */
	public static String insert(PatientBean pb) {
		
		String id = pb.getPatientId();
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
		
		String query = "INSERT INTO patients(patient_id, patient_given_name, patient_middle_initial, patient_last_name, patient_date_of_birth, "
				+ "patient_provider, patient_provider_id, patient_room, patient_gender, patient_type, patient_race, patient_ethnicity, "
				+ "patient_language_preference, patient_street_address, patient_city, patient_state, patient_country, patient_phone_number, "
				+ "patient_facility_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {

			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, givenName);
			preparedStatement.setString(3, middleInitial);
			preparedStatement.setString(4, lastName);
			preparedStatement.setObject(5, dateOfBirth);
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
