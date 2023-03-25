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
	
	public static EmergencyContactsBean get(String userPatientId) {
		
		EmergencyContactsBean emergencyContacts = new EmergencyContactsBean(userPatientId);
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "SELECT emergency_contacts.emergency_contact_given_name, emergency_contacts.emergency_contact_last_name, "
				+ "emergency_contacts.emergency_contact_phone_number, emergency_contacts.emergency_contact_email_address "
				+ "FROM emergency_contacts "
				+ "WHERE emergency_contacts.user_id = ?";

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
	
	public static String add(EmergencyContactsBean contacts) throws SQLException {
		
		String query = "INSERT INTO emergency_contacts(user_id, emergency_contact_given_name, emergency_contact_middle_initial, emergency_contact_last_name, "
				+ "emergency_contact_phone_number, emergency_contact_email_address) "
				+ "VALUES (?,?,?,?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				System.out.println("Adding emergency contact...");
				preparedStatement.setString(1, contacts.getUserPatientId());
				preparedStatement.setString(2, contacts.getFirstName());
				preparedStatement.setString(3, contacts.getMiddleInitial());
				preparedStatement.setString(4, contacts.getLastName());
				preparedStatement.setString(5, contacts.getPhoneNumber());
				preparedStatement.setString(6, contacts.getEmail());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add patient emergency contacts to the database!";
		}
		return "Successfully added patient emergency contacts to the database!";
	}
}