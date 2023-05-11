package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordROSBean;
import com.empty_works.plain_emrs.util.BlobConverter;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordROSDao {

	public static List<MedicalRecordROSBean> get(String medicalRecordId) {
		
		List<MedicalRecordROSBean> medRecordROSBeanList = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "SELECT review_of_systems_id, chief_complaint_id, constitutional_symptoms, eyes, ears_nose_throat, cardiovascular, "
				+ "respiratory, gastrointestinal, genitournary, musculoskeletal, integumentary, neurological, psychiatric, endocrine, "
				+ "hematologic_lymphatic, allergic_immunologic, reviews_of_systems_date "
				+ "FROM reviews_of_systems "
				+ "WHERE medical_record_id=?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, medicalRecordId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				MedicalRecordROSBean medRecordROSBean = new MedicalRecordROSBean();
				medRecordROSBean.setReviewOfSystemsId(rs.getInt("review_of_systems_id"));
				medRecordROSBean.setChiefComplaintId(rs.getString("chief_complaint_id"));
				medRecordROSBean.setConstitutionalSymptoms(BlobConverter.toStr(rs, "constitutional_symptoms"));
				medRecordROSBean.setEyes(BlobConverter.toStr(rs, "eyes"));
				medRecordROSBean.setEarsNoseThroat(BlobConverter.toStr(rs, "ears_nose_throat"));
				medRecordROSBean.setCardiovascular(BlobConverter.toStr(rs, "cardiovascular"));
				medRecordROSBean.setRespiratory(BlobConverter.toStr(rs, "respiratory"));
				medRecordROSBean.setGastrointestinal(BlobConverter.toStr(rs, "gastrointestinal"));
				medRecordROSBean.setGenitournary(BlobConverter.toStr(rs, "genitournary"));
				medRecordROSBean.setMusculoskeletal(BlobConverter.toStr(rs, "musculoskeletal"));
				medRecordROSBean.setIntegumentary(BlobConverter.toStr(rs, "integumentary"));
				medRecordROSBean.setNeurological(BlobConverter.toStr(rs, "neurological"));
				medRecordROSBean.setPsychiatric(BlobConverter.toStr(rs, "psychiatric"));
				medRecordROSBean.setEndocrine(BlobConverter.toStr(rs, "endocrine"));
				medRecordROSBean.setHematologicLymphatic(BlobConverter.toStr(rs, "hematologic_lymphatic"));
				medRecordROSBean.setAllergicImmunologic(BlobConverter.toStr(rs, "allergic_immunologic"));
				medRecordROSBean.setDate(rs.getObject("reviews_of_systems_date", LocalDateTime.class));
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
				+ "neurological, psychiatric, endocrine, hematologic_lymphatic, allergic_immunologic, reviews_of_systems_date) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medRecordROSBean.getChiefComplaintId());
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
				preparedStatement.setTimestamp(17, java.sql.Timestamp.valueOf(medRecordROSBean.getDate()));
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add review of systems to the database!";
		}
		return "Successfully added review of systems to the database!";
	}
}
