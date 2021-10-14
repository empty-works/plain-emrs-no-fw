package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.empty_works.plain_emrs.beans.NonPatientBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class RegisterNonPatientUserDao {

	final public static String NONPATIENTDAO_SUCCESS = "SUCCESS";
	
	public String register(NonPatientBean npb) {
		
		String id = npb.getId();
		String givenName = npb.getGivenName();
		String middleName = npb.getMiddleName();
		String lastName = npb.getLastName();
		String organization = npb.getOrganization();
		LocalDate dateOfBirth = npb.getDateOfBirth();
		String description = npb.getDescription();
		String wardId = npb.getWard();
		String staffPositionId = npb.getStaffPosition();
		String specialtyId = npb.getSpecialty();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		con = ConnectionUtil.getConnection();
		String query = "insert into nonpatients(nonpatient_id, given_name, middle_name, last_name, "
				+ "organization, date_of_birth, description, ward_id, staff_position_id, specialty_id) values (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, givenName);
			preparedStatement.setString(3, middleName);
			preparedStatement.setString(4, lastName);
			preparedStatement.setString(5, organization);
			preparedStatement.setDate(6, Date.valueOf(dateOfBirth));
			preparedStatement.setString(7, description);
			preparedStatement.setString(8, wardId);
			preparedStatement.setString(9, staffPositionId);
			preparedStatement.setString(10, specialtyId);
			
			int i = preparedStatement.executeUpdate();
			if(i != 0) return NONPATIENTDAO_SUCCESS;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Something went wrong in RegisterNonPatientUserDao...";
	}
}
