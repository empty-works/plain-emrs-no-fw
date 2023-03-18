package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MedicalRecordNurseNotesBean implements MedicalRecordInterface, BeanDaoInterface {

	private int nurseNoteId;
	private String medicalRecordId;
	private LocalDateTime datePosted;
	private String focus;
	private String text;
	
	public int getNurseNoteId() {
		return nurseNoteId;
	}

	public void setNurseNoteId(int nurseNoteId) {
		this.nurseNoteId = nurseNoteId;
	}

	public LocalDateTime getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(LocalDateTime datePosted) {
		this.datePosted = datePosted;
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String getWriteQuery() {
		return "INSERT INTO nurse_notes(nurse_note_id, medical_record_id, nurse_note_date_posted, nurse_note_focus, nurse_note_text) "
				+ "VALUES (?,?,?,?,?)";
	}

	@Override
	public String getErrorMessage() {
		return "Could not add to nurse_notes table!";
	}

	@Override
	public int prepareStatments(PreparedStatement preparedStatement) throws SQLException {
		
		System.out.println("Adding to nurse_notes table...");
		preparedStatement.setInt(1, getNurseNoteId());
		preparedStatement.setString(2, getMedicalRecordId());
		preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(getDatePosted()));
		preparedStatement.setString(4, getFocus());
		preparedStatement.setString(5, getText());
		return preparedStatement.executeUpdate();
	}

	@Override
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	@Override
	public String getMedicalRecordId() {
		return medicalRecordId;
	}
}
