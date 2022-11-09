package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.BeanDaoInterface;
import com.empty_works.plain_emrs.beans.MedicalRecordBean;
import com.empty_works.plain_emrs.beans.PatientBean;
import com.empty_works.plain_emrs.beans.SurgicalProblemsBean;
import com.empty_works.plain_emrs.beans.UserActivityLogBean;
import com.empty_works.plain_emrs.beans.UserBean;
import com.empty_works.plain_emrs.beans.UserLoginLogBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class AddUserDao {

	final public static String USERDAO_SUCCESS = "User successfully added!";
	private List<BeanDaoInterface> beans = new ArrayList<>();
	
	/**
	 * 
	 * @param bean
	 */
	public void add(BeanDaoInterface bean) {
		beans.add(bean);
	}
	
	/**
	 * 
	 * @return
	 */
	public String executeQueries() {
		
		boolean exceptionThrown = false;
		String thrownResult = "";

		try (Connection con = ConnectionUtil.getConnection()) {

			for(BeanDaoInterface bean : beans) {
				
				try(PreparedStatement preparedStatement = con.prepareStatement(bean.getQuery())) {
					
					bean.prepareStatments(preparedStatement);
				}
				catch (SQLException e) {
					
					exceptionThrown = true;
					thrownResult = bean.getErrorMessage();
				}
			}
		}
		catch (SQLException e) {
			
			exceptionThrown = true;
			thrownResult = "Connection failed in user DAO.";
		}
		if(exceptionThrown) {
			
			return thrownResult;
		}
		return USERDAO_SUCCESS;
	}
/*
	public static String add(UserBean user, UserLoginLogBean userLogin, UserActivityLogBean userActivity, 
			PatientBean patient, MedicalRecordBean medRecord, SurgicalProblemsBean surgicalProblems) { 
		
		String queryUser = "INSERT INTO users(user_id, user_password, user_email_address, user_enabled, user_created_on, current_facility_id, "
				+ "user_date_of_birth, user_first_name, user_middle_initial, user_last_name) values (?,?,?,?,?,?,?,?,?,?)";
		
		String queryRole = "INSERT INTO authorities(user_id, authority) values (?,?)";
		
		String queryUserLoginLog = "INSERT INTO user_login_logs(user_id, user_date_time_of_visit) values (?,?)"; 
	
		String queryUserActivity = "INSERT INTO user_activity_logs(user_id, medical_record_id, user_date_time_of_activity, activity_description) "
				+ "values (?,?,?,?)";
		
		String queryPatient = "INSERT INTO patients(user_id, patient_provider, patient_provider_id, patient_room, patient_current_gender, "
				+ "patient_type, patient_language_preference, patient_street_address, patient_city, patient_state, patient_country, "
				+ "patient_phone_number, patient_gender_at_birth, patient_sexual_orientation, patient_marital_status, patient_living_arrangement, "
				+ "patient_is_adopted) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		String patientRaceQuery = "INSERT INTO patient_races(patients_user_id, patient_race) values(?,?)";

		String queryMedRecord = "INSERT INTO medical_records(medical_record_id, user_id, patient_condition, medical_record_created_on, is_active, "
				+ "blood_transfusion_status) values (?,?,?,?,?,?)";
		
		String querySurgicalProcedure = "INSERT INTO surgical_related_problems(medical_record_id, surgical_related_problem, problem_area, "
				+ "surgical_procedure, surgical_procedure_year) values (?,?,?,?,?)";

		boolean exceptionThrown = false;
		String thrownResult = "";
		
		try (Connection con = ConnectionUtil.getConnection()) {
			
			try (PreparedStatement preparedStatement = con.prepareStatement(user.getQuery())) {
				
				user.prepareStatments(preparedStatement);
				System.out.println("Adding user...");
				preparedStatement.setString(1, user.getUserId());
				preparedStatement.setString(2, user.getUserPassword());
				preparedStatement.setString(3, user.getEmailAddress());
				preparedStatement.setBoolean(4, user.isUserEnabled());
				preparedStatement.setTimestamp(5, java.sql.Timestamp.valueOf(user.getDateCreated()));
				preparedStatement.setString(6, user.getCurrentFacilityId());
				preparedStatement.setDate(7, java.sql.Date.valueOf(user.getDateOfBirth()));
				preparedStatement.setString(8, user.getFirstName());
				preparedStatement.setString(9, user.getMiddleInitial());
				preparedStatement.setString(10, user.getLastName());
				preparedStatement.executeUpdate();
			}
			catch (SQLException e) {
				
				exceptionThrown = true;
				thrownResult = "Could not add user to users table!";
			}
			try (PreparedStatement preparedStatement = con.prepareStatement(queryRole)) {
				
				System.out.println("Adding role to authorities table...");
				preparedStatement.setString(1, user.getUserId());
				preparedStatement.setString(2, user.getRole());
				preparedStatement.executeUpdate();
			}
			catch (SQLException e) {
				
				exceptionThrown = true;
				thrownResult = "Could not add role to authorities table!";
			}
			try (PreparedStatement preparedStatement = con.prepareStatement(queryUserLoginLog)) {
				
				System.out.println("Adding user login log...");
				preparedStatement.setString(1, userLogin.getUserId());
				preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf(userLogin.getUserDateTimeOfVisit()));
				preparedStatement.executeUpdate();
			}
			catch (SQLException e) {
				
				exceptionThrown = true;
				thrownResult = "Could not add user login log to user_login_logs table!";
			}
			try (PreparedStatement preparedStatement = con.prepareStatement(queryUserActivity)) {
				
				System.out.println("Adding user activity log...");
				preparedStatement.setString(1, userActivity.getUserId());
				preparedStatement.setString(2, userActivity.getMedicalRecordId());
				preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(userActivity.getUserDateTimeOfActivity()));
				preparedStatement.setString(4, userActivity.getActivityDescription());
				preparedStatement.executeUpdate();
			}
			catch (SQLException e) {
				
				exceptionThrown = true;
				thrownResult = "Could not add user activity log to user_activity_logs table!";
			}
			try (PreparedStatement preparedStatement = con.prepareStatement(queryPatient)) {
				
				System.out.println("Adding patient...");
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
				preparedStatement.executeUpdate();
			}
			catch (SQLException e) {
				
				exceptionThrown = true;
				thrownResult = "Could not add patient to patients table! " + e;
			}
			try (PreparedStatement preparedStatement = con.prepareStatement(patientRaceQuery)) {
				
				for(int i = 0; i < patient.getRaces().size(); i++) {
					
					preparedStatement.setString(1, patient.getUserId());
					preparedStatement.setString(2, patient.getRaces().get(i));
					preparedStatement.addBatch();
				}
				preparedStatement.executeBatch();
			}
			catch(SQLException e) {
				
				exceptionThrown = true;
				thrownResult += "Could not add races to patient race table! ";
			}
			try (PreparedStatement preparedStatement = con.prepareStatement(queryMedRecord)) {
				preparedStatement.setString(1, medRecord.getMedicalRecordId());
				preparedStatement.setString(2, medRecord.getUserId());
				preparedStatement.setString(3, medRecord.getPatientCondition());
				preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(medRecord.getMedicalRecordCreatedOn()));
				preparedStatement.setBoolean(5, medRecord.isActive());
				preparedStatement.setString(6, medRecord.getBloodTransfusionStatus());
				preparedStatement.executeUpdate();
				
			} catch (SQLException e) {

				exceptionThrown = true;
				thrownResult += "Could not add medical record! ";
			}

			// Only execute if there are any surgical problems.
			if(surgicalProblems.getSurgeryMedProblems().size() > 0) {
				try (PreparedStatement preparedStatement = con.prepareStatement(querySurgicalProcedure)) {
					for(int i = 0; i < surgicalProblems.getSurgeryMedProblems().size(); i++) {
						preparedStatement.setString(1, surgicalProblems.getMedicalRecordId());
						preparedStatement.setString(2, surgicalProblems.getSurgeryMedProblems().get(i).getSurgicalRelatedProblem());
						preparedStatement.setString(3, surgicalProblems.getSurgeryMedProblems().get(i).getProblemArea());
						preparedStatement.setString(4, surgicalProblems.getSurgeryMedProblems().get(i).getSurgicalProcedure());
						preparedStatement.setString(5, surgicalProblems.getSurgeryMedProblems().get(i).getSurgicalProcedureYear());
						preparedStatement.addBatch();
					}
					preparedStatement.executeBatch();
				} catch (SQLException e) {

					exceptionThrown = true;
					thrownResult += "Could not add surgical procedures data! " + e;
				}
			}
		}
		catch (SQLException e) {
			
			exceptionThrown = true;
			thrownResult = "Connection failed in user DAO.";
		}
		if(exceptionThrown) {
			
			return thrownResult;
		}
		return USERDAO_SUCCESS;
	}
	*/
}
