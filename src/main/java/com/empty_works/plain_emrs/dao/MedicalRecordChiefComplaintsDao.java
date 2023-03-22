package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordChiefComplaintsBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordChiefComplaintsDao {

	public static List<MedicalRecordChiefComplaintsBean> get(String medicalRecordId) {
		
		List<MedicalRecordChiefComplaintsBean> medRecordChiefComplaintsBeanList = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "SELECT chief_complaint_id, admissions_id, statement "
				+ "FROM chief_complaints "
				+ "WHERE medical_record_id=?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, medicalRecordId);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				MedicalRecordChiefComplaintsBean medRecordChiefComplaintsBean = new MedicalRecordChiefComplaintsBean();
				medRecordChiefComplaintsBean.setChiefComplaintId(rs.getInt("chief_complaint_id"));
				medRecordChiefComplaintsBean.setAdmissionsId(rs.getInt("admissions_id"));
				medRecordChiefComplaintsBean.setStatement(rs.getString("statement"));
				medRecordChiefComplaintsBeanList.add(medRecordChiefComplaintsBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return medRecordChiefComplaintsBeanList;
	}
	
	public static String add(List<MedicalRecordChiefComplaintsBean> medRecordChiefComplaintsBeanList) {
		
		return MedicalRecordDao.add(medRecordChiefComplaintsBeanList);
	}
}
