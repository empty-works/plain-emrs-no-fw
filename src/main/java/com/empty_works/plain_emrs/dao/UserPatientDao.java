package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.UserPatientBean;
import com.empty_works.plain_emrs.roles.PlainEmrsRoles;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class UserPatientDao {

	final public static String PATIENTDAO_SUCCESS = "Successfully added patient to database!";
	final public static int PATIENT_FETCH_SIZE = 100;

	public static UserPatientBean getPatient(String userPatientId) {
		
		UserPatientBean patient = new UserPatientBean();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String patientQuery = "SELECT patients.patient_provider, patients.patient_provider_id, patients.patient_room, patients.patient_type, "
				+ "patients.patient_language_preference, patients.patient_street_address, patients.patient_city, patients.patient_state, patients.patient_country, "
				+ "patients.patient_phone_number, patients.patient_gender_at_birth, users.user_email_address, users.user_enabled, users.user_created_on, "
				+ "users.current_facility_id, users.user_first_name, users.user_middle_initial, users.user_last_name, users.user_date_of_birth, "
				+ "patients.patient_sexual_orientation, patients.patient_marital_status, patients.patient_living_arrangement, "
				+ "patients.patient_license_number, patients.patient_vehicle_serial_number, patients.patient_vehicle_plate_number, patients.patient_url, "
				+ "patients.patient_device_serial_number, patients.patient_ip_address "
				+ "FROM patients "
				+ "INNER JOIN users ON patients.user_id = users.user_id "
				+ "WHERE patients.user_id = ?";
		try {
			preparedStatement = con.prepareStatement(patientQuery);
			preparedStatement.setString(1, userPatientId);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				patient.setProvider(rs.getString("patient_provider"));
				patient.setProviderId(rs.getString("patient_provider_id"));
				patient.setRoomNumber(rs.getString("patient_room"));
				patient.setType(rs.getString("patient_type"));
				patient.setLanguagePreference(rs.getString("patient_language_preference"));
				patient.setStreetAddress(rs.getString("patient_street_address"));
				patient.setCity(rs.getString("patient_city"));
				patient.setState(rs.getString("patient_state"));
				patient.setCountry(rs.getString("patient_country"));
				patient.setPhoneNumber(rs.getString("patient_phone_number"));
				patient.setGenderAtBirth(rs.getString("patient_gender_at_birth"));
				patient.setEmailAddress(rs.getString("user_email_address"));
				patient.setUserEnabled(rs.getBoolean("user_enabled"));
				patient.setDateCreated(rs.getObject("user_created_on", LocalDateTime.class));
				patient.setCurrentFacilityId(rs.getString("current_facility_id"));
				patient.setFirstName(rs.getString("user_first_name"));
				patient.setMiddleInitial(rs.getString("user_middle_initial"));
				patient.setLastName(rs.getString("user_last_name"));
				patient.setDateOfBirth(rs.getObject("user_date_of_birth", LocalDate.class));
				patient.setSexualOrientation(rs.getString("patient_sexual_orientation"));
				patient.setMaritalStatus(rs.getString("patient_marital_status"));
				patient.setLivingArrangement(rs.getString("patient_living_arrangement"));
				patient.setLicenseNumber(rs.getString("patient_license_number"));
				patient.setVehicleSerialNumber(rs.getString("patient_vehicle_serial_number"));
				patient.setVehiclePlateNumber(rs.getString("patient_vehicle_plate_number"));
				patient.setUrl(rs.getString("patient_url"));
				patient.setDeviceSerialNumber(rs.getString("patient_device_serial_number"));
				patient.setIpAddress(rs.getString("patient_ip_address"));
			}
			System.out.println("patient bean after selection: " + patient.getFirstName());
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closeConnection(con, preparedStatement, null);
		}
		return patient;
	}
	
	/**
	 * 
	 * @param firstRow
	 * @param rowCount
	 * @return
	 */
	public static List<UserPatientBean> getList(int firstRow, int rowCount) {
		
		List<UserPatientBean> patientsList = new ArrayList<>();

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String SUBLIST_QUERY = "SELECT users.user_id, users.user_first_name, users.user_middle_initial, users.user_last_name, users.user_date_of_birth, patients.patient_type, "
				+ "patients.patient_current_gender, patients.patient_gender_at_birth, patients.patient_language_preference, authorities.authority "
				+ "FROM users "
				+ "INNER JOIN patients "
				+ "ON users.user_id = patients.user_id "
				+ "INNER JOIN authorities "
				+ "ON patients.user_id = authorities.user_id "
				+ "WHERE authorities.authority = %s "
				+ "ORDER BY users.user_last_name LIMIT %d OFFSET %d";
		
		String query = String.format(SUBLIST_QUERY, "'" + PlainEmrsRoles.ROLE_PATIENT.getRoleDb() + "'", rowCount, firstRow);

		try {

			preparedStatement = con.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				System.out.println("Inside patient sublist while loop.");
				UserPatientBean patient = new UserPatientBean();
				patient.setUserId(resultSet.getString("users.user_id"));
				patient.setFirstName(resultSet.getString("users.user_first_name"));
				patient.setMiddleInitial(resultSet.getString("users.user_middle_initial"));
				patient.setLastName(resultSet.getString("users.user_last_name"));
				patient.setDateOfBirth(resultSet.getDate("users.user_date_of_birth").toLocalDate());
				patient.setType(resultSet.getString("patients.patient_type"));
				patient.setCurrentGender(resultSet.getString("patients.patient_current_gender"));
				patient.setGenderAtBirth(resultSet.getString("patients.patient_gender_at_birth"));
				patient.setLanguagePreference(resultSet.getString("patients.patient_language_preference"));
				patient.setRole(resultSet.getString("authorities.authority"));
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
	public static String add(UserPatientBean patient) {
		
		String patientQuery = "INSERT INTO patients(user_id, patient_provider, patient_provider_id, patient_room, patient_current_gender, "
				+ "patient_type, patient_language_reference, patient_street_address, patient_city, patient_state, patient_country, "
				+ "patient_phone_number, patient_gender_at_birth, patient_sexual_orientation, patient_marital_status, patient_living_arrangement, "
				+ "patient_is_adopted) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
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
				preparedStatement.setString(10, patient.getState());
				preparedStatement.setString(11, patient.getCountry());
				preparedStatement.setString(12, patient.getPhoneNumber());
				preparedStatement.setString(13, patient.getGenderAtBirth());
				preparedStatement.setString(14, patient.getSexualOrientation());
				preparedStatement.setString(15, patient.getMaritalStatus());
				preparedStatement.setString(16, patient.getLivingArrangement());
				preparedStatement.setBoolean(17, patient.isAdopted());
			}
			catch(SQLException e) {
				
				exceptionThrown = true;
				thrownResult = "Could not add patient to patients table! ";
			}

			try (PreparedStatement preparedStatement = con.prepareStatement(patientRaceQuery)) {
			/*	
				for(int i = 0; i < patient.getRaces().size(); i++) {
					
					preparedStatement.setString(1, patient.getUserId());
					preparedStatement.setString(2, patient.getRaces().get(i));
				}
				*/
			}
			catch(SQLException e) {
				
				exceptionThrown = true;
				thrownResult += "Could not add races to patient race table! ";
			}
		}	
		catch(SQLException e) {
			
			exceptionThrown = true;
			thrownResult += "Something went wrong with connection for adding a patient.";
		}
		if(exceptionThrown) {
			return thrownResult;
		}
		else {
			return PATIENTDAO_SUCCESS;
		}
	}
}
