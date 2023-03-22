package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicalRecordChiefComplaintsBean implements MedicalRecordInterface, BeanDaoInterface {

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
	public String getWriteQuery() {
		return "INSERT INTO chief_complaints(chief_complaint_id, medical_record_id, admissions_id, statement) "
				+ "values (?,?,?,?)";
	}

	@Override
	public String getWriteErrorMessage() {
		return "Could not add to the chief_complaints table!";
	}

	@Override
	public int prepareWriteStatement(PreparedStatement preparedStatement) throws SQLException {
		System.out.println("Adding to the chief_complaints table...");
		preparedStatement.setInt(1, getChiefComplaintId());
		preparedStatement.setString(2, getMedicalRecordId());
		preparedStatement.setInt(3, getAdmissionsId());
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
