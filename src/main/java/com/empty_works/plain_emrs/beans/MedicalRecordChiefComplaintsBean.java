package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicalRecordChiefComplaintsBean implements PatientIdInterface, BeanDaoInterface {

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
	public void setUserId(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMedicalRecordId(String medicalRecordId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMedicalRecordId() {
		// TODO Auto-generated method stub
		return null;
	}
}
