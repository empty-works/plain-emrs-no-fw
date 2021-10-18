package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import com.empty_works.plain_emrs.beans.GeneratedUserBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class RegisterGeneratedUserDao {

	public static String GENERATEDUSERDAO_SUCCESS = "Success";

	public static String register(GeneratedUserBean gub) {
		
		String userName = gub.getUsername();
		String password = gub.getPassword();
		String emailAddress = gub.getEmailAddress();
		LocalDateTime createdOn = gub.getCreatedOn();
		String patientId = gub.getPatientId();
		String nonpatientId = gub.getNonPatientId();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		con = ConnectionUtil.getConnection();
		
		
		
		return "";
	}
}
