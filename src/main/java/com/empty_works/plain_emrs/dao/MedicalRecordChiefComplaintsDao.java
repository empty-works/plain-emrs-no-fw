package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordChiefComplaintsBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordChiefComplaintsDao {

	public static List<MedicalRecordChiefComplaintsBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordChiefComplaintsBean> medRecordChiefComplaintsBeanList = new ArrayList<>();
		String query = "SELECT chief_complaint_id, admissions_id, statement, chief_complaint_date "
				+ "FROM chief_complaints "
				+ "WHERE medical_record_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				
				System.out.println("Retrieving from the chief_complaints table...");
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordChiefComplaintsBean medRecordChiefComplaintsBean = new MedicalRecordChiefComplaintsBean();
					medRecordChiefComplaintsBean.setChiefComplaintId(rs.getString("chief_complaint_id"));
					medRecordChiefComplaintsBean.setAdmissionsId(rs.getInt("admissions_id"));
					medRecordChiefComplaintsBean.setStatement(rs.getString("statement"));
					medRecordChiefComplaintsBean.setDate(rs.getObject("chief_complaint_date", LocalDateTime.class));
					medRecordChiefComplaintsBeanList.add(medRecordChiefComplaintsBean);
				}
			}
		}
		return medRecordChiefComplaintsBeanList;
	}
	
	public static int add(MedicalRecordChiefComplaintsBean medRecordChiefComplaintsBean) {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "INSERT INTO chief_complaints(medical_record_id, admissions_id, statement, chief_complaint_date) "
				+ "VALUES (?,?,?,?)";
		
		int success = 0;
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, medRecordChiefComplaintsBean.getMedicalRecordId());
			preparedStatement.setInt(2, medRecordChiefComplaintsBean.getAdmissionsId());
			preparedStatement.setString(3, medRecordChiefComplaintsBean.getStatement());
			preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(medRecordChiefComplaintsBean.getDate()));
			success = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}
}
