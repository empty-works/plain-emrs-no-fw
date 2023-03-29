package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MedicalRecordNurseNotesBean implements MedicalRecordInterface {

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
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	@Override
	public String getMedicalRecordId() {
		return medicalRecordId;
	}
}
