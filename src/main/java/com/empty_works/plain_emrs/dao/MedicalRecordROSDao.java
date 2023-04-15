package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordROSBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordROSDao {

	public static List<MedicalRecordROSBean> get(String medicalRecordId) {
		
		List<MedicalRecordROSBean> medRecordROSBeanList = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "SELECT review_of_systems_id, chief_complaint_id, constitutional_symptoms, eyes, ears_nose_throat, cardiovascular, "
				+ "respiratory, gastrointestinal, genitournary, musculoskeletal, integumentary, neurological, psychiatric, endocrine, "
				+ "hematologic_lymphatic, allergic_immunologic "
				+ "FROM reviews_of_systems "
				+ "WHERE medical_record_id=?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, medicalRecordId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				MedicalRecordROSBean medRecordROSBean = new MedicalRecordROSBean();
				medRecordROSBean.setReviewOfSystemsId(rs.getInt("review_of_systems_id"));
				medRecordROSBean.setChiefComplaintId(rs.getInt("chief_complaint_id"));
				medRecordROSBean.setConstitutionalSymptoms(rs.getString("constitutional_symptoms"));
				medRecordROSBean.setEyes(rs.getString(rs.getString("eyes")));
				medRecordROSBean.setEarsNoseThroat(rs.getString("ears_nose_throat"));
				medRecordROSBean.setCardiovascular(rs.getString("cardiovascular"));
				medRecordROSBean.setRespiratory(rs.getString("respiratory"));
				medRecordROSBean.setGastrointestinal(rs.getString("gastrointestinal"));
				medRecordROSBean.setGenitournary(rs.getString("genitournary"));
				medRecordROSBean.setMusculoskeletal(rs.getString("musculoskeletal"));
				medRecordROSBean.setIntegumentary(rs.getString("integumentary"));
				medRecordROSBean.setNeurological(rs.getString("neurological"));
				medRecordROSBean.setPsychiatric(rs.getString("psychiatric"));
				medRecordROSBean.setEndocrine(rs.getString("endocrine"));
				medRecordROSBean.setHematologicLymphatic(rs.getString("hematologic_lymphatic"));
				medRecordROSBean.setAllergicImmunologic(rs.getString("allergic_immunologic"));
				medRecordROSBeanList.add(medRecordROSBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return medRecordROSBeanList;
	}
	
	public static String add(MedicalRecordROSBean medRecordROSBean) throws SQLException {
		
		String query = "INSERT INTO reviews_of_systems(chief_complaint_id, medical_record_id, constitutional_symptoms, eyes, "
				+ "ears_nose_throat, cardiovascular, respiratory, gastrointestinal, genitournary, musculoskeletal, integumentary, "
				+ "neurological, psychiatric, endocrine, hematologic_lymphatic, allergic_immunologic) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setInt(1, medRecordROSBean.getChiefComplaintId());
				preparedStatement.setString(2, medRecordROSBean.getMedicalRecordId());
				preparedStatement.setString(3, medRecordROSBean.getConstitutionalSymptoms());
				preparedStatement.setString(4, medRecordROSBean.getEyes());
				preparedStatement.setString(5, medRecordROSBean.getEarsNoseThroat());
				preparedStatement.setString(6, medRecordROSBean.getCardiovascular());
				preparedStatement.setString(7, medRecordROSBean.getRespiratory());
				preparedStatement.setString(8, medRecordROSBean.getGastrointestinal());
				preparedStatement.setString(9, medRecordROSBean.getGenitournary());
				preparedStatement.setString(10, medRecordROSBean.getMusculoskeletal());
				preparedStatement.setString(11, medRecordROSBean.getIntegumentary());
				preparedStatement.setString(12, medRecordROSBean.getNeurological());
				preparedStatement.setString(13, medRecordROSBean.getPsychiatric());
				preparedStatement.setString(14, medRecordROSBean.getEndocrine());
				preparedStatement.setString(15, medRecordROSBean.getHematologicLymphatic());
				preparedStatement.setString(16, medRecordROSBean.getAllergicImmunologic());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add review of systems to the database!";
		}
		return "Successfully added review of systems to the database!";
	}
}