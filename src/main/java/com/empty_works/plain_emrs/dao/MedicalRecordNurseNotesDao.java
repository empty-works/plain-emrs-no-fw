package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordNurseNotesBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordNurseNotesDao {

	public static List<MedicalRecordNurseNotesBean> get(String medicalRecordId) {
		
		List<MedicalRecordNurseNotesBean> medRecordNurseNotesBeanList = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "SELECT nurse_note_id, nurse_note_date_posted, nurse_note_focus, nurse_note_text "
				+ "FROM nurse_notes "
				+ "WHERE medical_record_id=?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, medicalRecordId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				MedicalRecordNurseNotesBean medRecordNurseNotes = new MedicalRecordNurseNotesBean();
				medRecordNurseNotes.setNurseNoteId(rs.getInt("nurse_note_id"));
				medRecordNurseNotes.setDatePosted(rs.getObject("nurse_note_date_posted", LocalDateTime.class));
				medRecordNurseNotes.setFocus(rs.getString("nurse_note_focus"));
				medRecordNurseNotes.setText(rs.getString("nurse_note_text"));
				medRecordNurseNotesBeanList.add(medRecordNurseNotes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return medRecordNurseNotesBeanList;
	}
	
	public static String add(MedicalRecordNurseNotesBean medRecordNurseNotesBean) {
		
		return MedicalRecordDao.add(medRecordNurseNotesBean);
	}
}
