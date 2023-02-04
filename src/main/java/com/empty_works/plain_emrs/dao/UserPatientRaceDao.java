package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.BeanDaoInterface;
import com.empty_works.plain_emrs.beans.PatientRaceBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class UserPatientRaceDao {
	
	final public static String USERDAO_SUCCESS = "User successfully added!";
	private List<BeanDaoInterface> beans = new ArrayList<>();
	
	public static PatientRaceBean getRace(String userPatientId) {
		
		PatientRaceBean raceBean = new PatientRaceBean();
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
}
