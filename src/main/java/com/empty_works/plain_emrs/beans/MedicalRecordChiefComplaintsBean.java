package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicalRecordChiefComplaintsBean implements MedicalRecordInterface {

	private String medicalRecordId;
	private int chiefComplaintId;
	private int admissionsId;
	private String statement;
	
	public int getChiefComplaintId() {
		return chiefComplaintId;
	}

	public void setChiefComplaintId(int chiefComplaintId) {
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
}
