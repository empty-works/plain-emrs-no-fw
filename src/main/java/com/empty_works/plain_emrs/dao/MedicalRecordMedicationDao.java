package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordMedicationBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordMedicationDao {

	public static List<MedicalRecordMedicationBean> get(String medicalRecordId) {
		
		List<MedicalRecordMedicationBean> medRecordMedicationBeanList = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "SELECT medication_id, medication_name, medication_is_current, medication_description "
				+ "FROM medication "
				+ "WHERE medical_record_id=?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, medicalRecordId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				MedicalRecordMedicationBean medRecordMedicationBean = new MedicalRecordMedicationBean();
				medRecordMedicationBean.setMedicationId(rs.getInt("medication_id"));
				medRecordMedicationBean.setMedicationName(rs.getString("medication_name"));
				medRecordMedicationBean.setMedicationIsCurrent(rs.getBoolean("medication_is_current"));
				medRecordMedicationBean.setMedicationDescription(rs.getString("medication_description"));
				medRecordMedicationBeanList.add(medRecordMedicationBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return medRecordMedicationBeanList;
	}
	
	public static String add(MedicalRecordMedicationBean medRecordMedicationBean) {
		
		return MedicalRecordDao.add(medRecordMedicationBean);
	}
}
