package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordIllnessesBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordIllnessesDao {

	public static List<MedicalRecordIllnessesBean> get(String medicalRecordId) {
		
		List<MedicalRecordIllnessesBean> medRecordIllnessesBeanList = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "SELECT illness_id, illness, self, father, mother, brothers, sisters, sons, daughters, grandparents "
				+ "FROM illnesses "
				+ "WHERE medical_record_id=?";

		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, medicalRecordId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				MedicalRecordIllnessesBean medRecordIllnessesBean = new MedicalRecordIllnessesBean();
				medRecordIllnessesBean.setIllnessId(rs.getInt("illness_id"));
				medRecordIllnessesBean.setIllness(rs.getString("illness"));
				medRecordIllnessesBean.setIllnessSelf(rs.getBoolean("self"));
				medRecordIllnessesBean.setIllnessFather(rs.getBoolean("father"));
				medRecordIllnessesBean.setIllnessMother(rs.getBoolean("mother"));
				medRecordIllnessesBean.setIllnessBrothers(rs.getBoolean("brothers"));
				medRecordIllnessesBean.setIllnessSisters(rs.getBoolean("sisters"));
				medRecordIllnessesBean.setIllnessSons(rs.getBoolean("sons"));
				medRecordIllnessesBean.setIllnessDaughters(rs.getBoolean("daughters"));
				medRecordIllnessesBean.setIllnessGrandparents(rs.getBoolean("grandparents"));
				medRecordIllnessesBeanList.add(medRecordIllnessesBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return medRecordIllnessesBeanList;
	}
	
	public static String add(MedicalRecordIllnessesBean medRecordIllnessesBean) {
		
		return MedicalRecordDao.add(medRecordIllnessesBean);
	}
}
