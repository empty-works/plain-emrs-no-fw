package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordVisitsBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordVisitsDao {

	public static List<MedicalRecordVisitsBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordVisitsBean> visits = new ArrayList<>();
		String query = "SELECT visit_id, visits_title, visits_date, visits_description "
				+ "FROM visits "
				+ "WHERE medical_record_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordVisitsBean visit = new MedicalRecordVisitsBean();
					visit.setVisitId(rs.getInt("visit_id"));
					visit.setVisitsTitle(rs.getString("visits_title"));
					visit.setVisitsDate(rs.getObject("visits_date", LocalDateTime.class));
					visit.setDescription(rs.getString("visits_description"));
					visits.add(visit);
				}
			}
		}
		return visits;
	}
	
	public static String add(MedicalRecordVisitsBean visit) throws SQLException {
		
		String query = "INSERT INTO visits(medical_record_id, visits_title, visits_date, visits_description) "
				+ "VALUES (?,?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, visit.getMedicalRecordId());
				preparedStatement.setString(2, visit.getVisitsTitle());
				preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(visit.getVisitsDate()));
				preparedStatement.setString(4, visit.getDescription());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add to the visits table!";
		}
		return "Successfully added to the visits table!";
	}
}
