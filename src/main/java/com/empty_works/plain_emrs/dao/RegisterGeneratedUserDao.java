package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.empty_works.plain_emrs.beans.GeneratedUserBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class RegisterGeneratedUserDao {

	public static String GENERATEDUSERDAO_SUCCESS = "Success";

	public static String register(GeneratedUserBean gub) {
		
		String username = gub.getUsername();
		String password = gub.getPassword();
		String emailAddress = gub.getEmailAddress();
		LocalDateTime createdOn = gub.getCreatedOn();
		String patientId = gub.getPatientId();
		String nonpatientId = gub.getNonPatientId();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		con = ConnectionUtil.getConnection();
		String query = "insert into users("
				+ "user_name, user_password, user_email_address, user_created_on, patient_id, nonpatient_id) "
				+ "values (?,?,?,?,?,?)";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, emailAddress);
			preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(createdOn));
			preparedStatement.setString(5, patientId);
			preparedStatement.setString(6, nonpatientId);

			int i = preparedStatement.executeUpdate();
			if(i != 0) return GENERATEDUSERDAO_SUCCESS;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Something went wrong registering the generated user...";
	}
}
