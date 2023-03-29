package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordPhysicalExamsBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordPhysicalExamsDao {

	public static List<MedicalRecordPhysicalExamsBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordPhysicalExamsBean> physExams = new ArrayList<>();
		
		String query = "SELECT physical_exam_id, chief_complaint_id, heent, respiratory, cardiovascular, abdominal, limbs, neurological "
				+ "FROM physical_exams "
				+ "WHERE medical_record_id=?";
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				System.out.println("Retrieving from the physical exams table...");
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordPhysicalExamsBean physExam = new MedicalRecordPhysicalExamsBean();
					physExam.setPhysicalExamId(rs.getInt("physical_exam_id"));
					physExam.setChiefComplaintId(rs.getInt("chief_complaint_id"));
					physExam.setHeent(rs.getString("heent"));
					physExam.setRespiratory(rs.getString("respiratory"));
					physExam.setCardiovascular(rs.getString("cardiovascular"));
					physExam.setAbdominal(rs.getString("abdominal"));
					physExam.setLimbs(rs.getString("limbs"));
					physExam.setNeurological(rs.getString("neurological"));
					physExams.add(physExam);
				}
			} 
			return physExams;
		}
	}
}
