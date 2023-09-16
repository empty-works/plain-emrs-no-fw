package com.empty_works.plain_emrs.beans;

import java.time.LocalDateTime;

public class MedicalRecordChiefComplaintsBean implements MedicalRecordInterface {

	private String medicalRecordId;
	private String chiefComplaintId;
	private int admissionsId;
	private String statement;
	private LocalDateTime date;
	
	public String getChiefComplaintId() {
		return chiefComplaintId;
	}

	public void setChiefComplaintId(String chiefComplaintId) {
		this.chiefComplaintId = chiefComplaintId;
	}

	public int getAdmissionsId() {
		return admissionsId;
	}

	public void setAdmissionsId(int admissionsId) {
		this.admissionsId = admissionsId;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	@Override
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	@Override
	public String getMedicalRecordId() {
		return medicalRecordId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
