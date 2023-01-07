package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.EmergencyContactsBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class EmergencyContactsDao {

	final public static String EMERGENCYCONTACTSDAO_SUCCESS = "Successfully added emergency contacts to database!";
	final public static int EMERGENCYCONTACTS_FETCH_SIZE = 100;
	
	public static EmergencyContactsBean getEmergencyContacts(String userPatientId) {
		
		EmergencyContactsBean emergencyContacts = new EmergencyContactsBean();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "SELECT emergency_contacts.emergency_contact_given_name, emergency_contacts.emergency_contact_last_name, "
				+ "emergency_contacts.emergency_contact_phone_number, emergency_contacts.emergency_contact_email_address "
				+ "FROM ((patient_emergency_contacts "
				+ "INNER JOIN patient_emergency_contacts ON patients.user_id = patient_emergency_contacts.user_id) "
				+ "INNER JOIN emergency_contacts ON patient_emergency_contacts.patient_emergency_contact_id = emergency_contacts.emergency_contact_id) "
				+ "WHERE patients.user_id = ?";

		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, userPatientId);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				emergencyContacts.setFirstName(rs.getString("emergency_contact_given_name"));
				emergencyContacts.setLastName(rs.getString("emergency_contact_last_name"));
				emergencyContacts.setPhoneNumber(rs.getString("emergency_contact_phone_number"));
				emergencyContacts.setEmail(rs.getString("emergency_contact_email_address"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closeConnection(con, preparedStatement, null);
		}
		return emergencyContacts;
	}
	
	
}