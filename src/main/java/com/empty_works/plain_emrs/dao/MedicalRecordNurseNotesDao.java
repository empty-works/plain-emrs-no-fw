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

	public static List<MedicalRecordNurseNotesBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordNurseNotesBean> medRecordNurseNotesBeanList = new ArrayList<>();
		String query = "SELECT nurse_note_id, nurse_note_date_posted, nurse_note_focus, nurse_note_text "
				+ "FROM nurse_notes "
				+ "WHERE medical_record_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				System.out.println("Retrieving from the nurse_notes table...");
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordNurseNotesBean medRecordNurseNotes = new MedicalRecordNurseNotesBean();
					medRecordNurseNotes.setNurseNoteId(rs.getInt("nurse_note_id"));
					medRecordNurseNotes.setDatePosted(rs.getObject("nurse_note_date_posted", LocalDateTime.class));
					medRecordNurseNotes.setFocus(rs.getString("nurse_note_focus"));
					medRecordNurseNotes.setText(rs.getString("nurse_note_text"));
					medRecordNurseNotesBeanList.add(medRecordNurseNotes);
				}
			}
		}
		return medRecordNurseNotesBeanList;
	}
	
	public static String add(MedicalRecordNurseNotesBean medRecordNurseNotesBean) throws SQLException {
		
		String query = "INSERT INTO nurse_notes(medical_record_id, nurse_note_date_posted, nurse_note_focus, nurse_note_text) "
				+ "VALUES (?,?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medRecordNurseNotesBean.getMedicalRecordId());
				preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf(medRecordNurseNotesBean.getDatePosted()));
				preparedStatement.setString(3, medRecordNurseNotesBean.getFocus());
				preparedStatement.setString(4, medRecordNurseNotesBean.getText());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add nurse notes to the database!";
		}
		return "Successfully added nurse notes to the database!";
	}
}
