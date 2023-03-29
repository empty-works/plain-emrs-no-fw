package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.empty_works.plain_emrs.beans.UserPatientRaceBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class UserPatientRaceDao {
	
	final public static String USERDAO_SUCCESS = "User successfully added!";
	
	public static UserPatientRaceBean get(String userPatientId) {
		
		UserPatientRaceBean raceBean = new UserPatientRaceBean();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String raceQuery = "SELECT patient_race "
				+ "FROM patient_races "
				+ "WHERE user_id = ?";

		try {
			preparedStatement = con.prepareStatement(raceQuery);
			preparedStatement.setString(1, userPatientId);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				raceBean.addRace(rs.getString("patient_race"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closeConnection(con, preparedStatement, null);
		}
		return raceBean;
	}
	
	public static String add(UserPatientRaceBean patientRace) throws SQLException {
		
		String query = "INSERT INTO patient_races(user_id, patient_race) values(?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				for(int i = 0; i < patientRace.getRaces().size(); i++) {
					
					preparedStatement.setString(1, patientRace.getUserId());
					preparedStatement.setString(2, patientRace.getRaces().get(i));
					preparedStatement.addBatch();
				}
				success =  preparedStatement.executeBatch()[0];
			}
		}
		if(success == 0) {
			return "Could not add patient races to the database!";
		}
		return "Successfully added patient races to the database!";
	}
}
