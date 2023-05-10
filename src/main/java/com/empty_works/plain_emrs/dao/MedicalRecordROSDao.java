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
				preparedStatement.setBlob(3, BlobConverter.convert(con, medRecordROSBean.getConstitutionalSymptoms()));
				preparedStatement.setBlob(4, BlobConverter.convert(con, medRecordROSBean.getEyes()));
				preparedStatement.setBlob(5, BlobConverter.convert(con, medRecordROSBean.getEarsNoseThroat()));
				preparedStatement.setBlob(6, BlobConverter.convert(con, medRecordROSBean.getCardiovascular()));
				preparedStatement.setBlob(7, BlobConverter.convert(con, medRecordROSBean.getRespiratory()));
				preparedStatement.setBlob(8, BlobConverter.convert(con, medRecordROSBean.getGastrointestinal()));
				preparedStatement.setBlob(9, BlobConverter.convert(con, medRecordROSBean.getGenitournary()));
				preparedStatement.setBlob(10, BlobConverter.convert(con, medRecordROSBean.getMusculoskeletal()));
				preparedStatement.setBlob(11, BlobConverter.convert(con, medRecordROSBean.getIntegumentary()));
				preparedStatement.setBlob(12, BlobConverter.convert(con, medRecordROSBean.getNeurological()));
				preparedStatement.setBlob(13, BlobConverter.convert(con, medRecordROSBean.getPsychiatric()));
				preparedStatement.setBlob(14, BlobConverter.convert(con, medRecordROSBean.getEndocrine()));
				preparedStatement.setBlob(15, BlobConverter.convert(con, medRecordROSBean.getHematologicLymphatic()));
				preparedStatement.setBlob(16, BlobConverter.convert(con, medRecordROSBean.getAllergicImmunologic()));
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
