package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicalRecordChiefComplaintsBean implements MedicalRecordInterface, BeanDaoInterface {

	private String medicalRecordId;
	private int chiefComplaintId;
	private int addmissionsId;
	private String statement;
	
	public int getChiefComplaintId() {
		return chiefComplaintId;
	}

	public void setChiefComplaintId(int chiefComplaintId) {
		this.chiefComplaintId = chiefComplaintId;
	}

	public int getAddmissionsId() {
		return addmissionsId;
	}

	public void setAddmissionsId(int addmissionsId) {
		this.addmissionsId = addmissionsId;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	@Override
	public String getWriteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int prepareStatments(PreparedStatement preparedStatement) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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
