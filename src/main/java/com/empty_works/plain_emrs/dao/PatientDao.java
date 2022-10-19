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

	public static PatientBean getPatient(PatientBean patient) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "SELECT patient_provider, patient_provider_id, patient_room, patient_gender, patient_type, "
				+ "patient_race, patient_ethnicity, patient_language_preference, patient_street_address, "
				+ "patient_city, patient_state, patient_country, patient_phone_number, patient_gender_at_birth, patient_sexual_orientation, "
				+ "patient_marital_status, patient_living_arrangement, patient_is_adopted"
				+ " FROM patients WHERE patient_id=?";
		
		System.out.println("Patient get query: " + query);
		
		try {

			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, patient.getUserId());
			ResultSet resultSet = preparedStatement.executeQuery();
			// Check if the result set is empty.
			if(resultSet.next()) {InputStream stream = resultSet.getBinaryStream(1);}
			
			//patient.setPatientId(patientId);
			//patient.setGivenName(resultSet.getString("patient_given_name"));
			patient.setMiddleInitial(resultSet.getString("patient_middle_initial"));
			patient.setLastName(resultSet.getString("patient_last_name"));
			//patient.setDateOfBirth(resultSet.getObject("patient_date_of_birth", LocalDate.class));
			patient.setProvider(resultSet.getString("patient_provider"));
			patient.setProviderId(resultSet.getString("patient_provider_id"));
			patient.setRoomNumber(resultSet.getString("patient_room"));
			patient.setCurrentGender(resultSet.getString("patient_gender"));
			patient.setType(resultSet.getString("patient_type"));
			//patient.setRace(resultSet.getString("patient_race"));
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
				//patient.setPatientId(resultSet.getString("patient_id"));
				//patient.setGivenName(resultSet.getString("patient_given_name"));
				patient.setMiddleInitial(resultSet.getString("patient_middle_initial"));
				patient.setLastName(resultSet.getString("patient_last_name"));
				//patient.setDateOfBirth(resultSet.getObject("patient_date_of_birth", LocalDate.class));
				patient.setCurrentGender(resultSet.getString("patient_gender"));
				patient.setType(resultSet.getString("patient_type"));
				//patient.setRace(resultSet.getString("patient_race"));
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
	 * @param patient
	 * @return
	 * @throws SQLException 
	 */
	public static String add(PatientBean patient) throws SQLException {
		
		String patientQuery = "INSERT INTO patients(user_id, patient_provider, patient_provider_id, patient_room, patient_current_gender, "
				+ "patient_type, patient_language_reference, patient_street_address, patient_city, patient_state, patient_country, "
				+ "patient_phone_number, patient_gender_at_birth, patient_sexual_orientation, patient_marital_status, patient_living_arrangement, "
				+ "patient_is_adopted) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		String patientRaceQuery = "INSERT INTO patient_races(patients_user_id, patient_race) values(?,?)";
		
		boolean exceptionThrown = false;
		String thrownResult = "";
		
		// Using try-with-resources to insert into multiple tables.
		try (Connection con = ConnectionUtil.getConnection()) {
			
			try (PreparedStatement preparedStatement = con.prepareStatement(patientQuery)) {
				
				preparedStatement.setString(1, patient.getUserId());
				preparedStatement.setString(2, patient.getProvider());
				preparedStatement.setString(3, patient.getProviderId());
				preparedStatement.setString(4, patient.getRoomNumber());
				preparedStatement.setString(5, patient.getCurrentGender());
				preparedStatement.setString(6, patient.getType());
				preparedStatement.setString(7, patient.getLanguagePreference());
				preparedStatement.setString(8, patient.getStreetAddress());
				preparedStatement.setString(9, patient.getCity());
				preparedStatement.setString(10, patient.getCountry());
				preparedStatement.setString(11, patient.getPhoneNumber());
				preparedStatement.setString(12, patient.getGenderAtBirth());
				preparedStatement.setString(13, patient.getSexualOrientation());
				preparedStatement.setString(14, patient.getMaritalStatus());
				preparedStatement.setString(15, patient.getLivingArrangement());
				preparedStatement.setBoolean(16, patient.isAdopted());
			}
			catch(SQLException e) {
				
				exceptionThrown = true;
				thrownResult = "Could not add patient to patients table! ";
			}

			try (PreparedStatement preparedStatement = con.prepareStatement(patientRaceQuery)) {
				
				for(int i = 0; i < patient.getRaces().size(); i++) {
					
					preparedStatement.setString(1, patient.getUserId());
					preparedStatement.setString(2, patient.getRaces().get(i));
				}
			}
			catch(SQLException e) {
				
				exceptionThrown = true;
				thrownResult += "Could not add patient to patients table!";
			}
		}	
		if(exceptionThrown) {
			return thrownResult;
		}
		else {
			return "Patient successfully added to database!";
		}
	}
}
